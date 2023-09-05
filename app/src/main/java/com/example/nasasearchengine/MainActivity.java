package com.example.nasasearchengine;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    EditText et_search;
    Button b_search;
    RecyclerView recyclerView;

    ArrayList<SearchResult> searchResults = new ArrayList<>();
    ArrayList<String> images = new ArrayList<>();
    ArrayList<String> results = new ArrayList<>();
    ArrayList<String> descriptions = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** to test program on Android emulator; comment out if using device **/
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        et_search = findViewById(R.id.et_search);
        b_search = findViewById(R.id.b_search);

        b_search.setOnClickListener(v -> {
            String searchTerms = et_search.getText().toString();
            String[] Terms = searchTerms.split(" ");
            if(!searchTerms.equals("")) {
                String apiUrl = "https://images-api.nasa.gov/search?q=";
                for(int i = 0; i < Terms.length; i++) {
                    if(i > 0) {
                        apiUrl += "%20";
                    }
                    apiUrl += Terms[i];
                }
                apiUrl += "&media_type=image";
                sendAPIRequest(apiUrl);
            }
        });

    }
    public void sendAPIRequest(String searchUrl) {
        /** display first 100 search results with Image and Title **/
        Request request = new Request.Builder().url(searchUrl).build();

        try (Response response = client.newCall(request).execute()) {
            runOnUiThread(() -> {
                try {
                    String jsonData = response.body().string();
                    JSONObject JsonObject = new JSONObject(jsonData);

                    JSONObject collection = JsonObject.getJSONObject("collection");
                    int numOfItems = collection.getJSONObject("metadata").getInt("total_hits");

                    if(!(numOfItems == 0) && numOfItems <= 10000) {
                        int pages = (int) Math.ceil( (double) numOfItems / 100);
                        for (int i = 0; i < pages; i++) {
                            JSONArray items = collection.getJSONArray("items");
                            if(i > 0) {
                                /** load additional items into array **/
                            }
                            for (int j = 0; j < items.length(); j++) {
                                createSearchResults(items.getJSONObject(j));
                            }
                        }

                        displaySearchResults();
                    } else {
                        System.out.println("No results found!");
                     }

                } catch (IOException | JSONException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void createSearchResults(JSONObject result) throws JSONException {
        /** would have also checked whether it was one image or an album **/
        JSONArray data = result.getJSONArray("data");
        JSONObject dataObject = data.getJSONObject(0);

        results.add(dataObject.getString("title"));
        images.add(result.getJSONArray("links").getJSONObject(0).getString("href"));
        descriptions.add(dataObject.getString("description"));

        /** would have properly formatted date to MM DD YY, Time **/
        dates.add(dataObject.getString("date_created"));

        searchResults.add(new SearchResult(
                results.get(results.size()-1),
                images.get(images.size()-1),
                descriptions.get(descriptions.size()-1),
                dates.get(dates.size()-1))
        );

    }
    protected void displaySearchResults() {
        recyclerView = findViewById(R.id.r_search);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, searchResults, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onClick(int position) {
         Intent intent = new Intent(MainActivity.this, MainActivity2.class);

         intent.putExtra("IMAGE", searchResults.get(position).getImage());
         intent.putExtra("TITLE",  searchResults.get(position).getTitle());
         intent.putExtra("DESCRIPTION", searchResults.get(position).getDescription());
         intent.putExtra("DATE", searchResults.get(position).getDate());

         startActivity(intent);
    }
}

