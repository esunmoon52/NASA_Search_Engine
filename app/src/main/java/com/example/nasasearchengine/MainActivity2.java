package com.example.nasasearchengine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");
        String date = getIntent().getStringExtra("DATE");
        String image = getIntent().getStringExtra("IMAGE");

        TextView titleTextView = findViewById(R.id.textView2);
        TextView descTextView = findViewById(R.id.textView3);
        TextView dateTextView = findViewById(R.id.textView4);
        ImageView imageView = findViewById(R.id.imageView2);

        Picasso.get().load(image).into(imageView);
        titleTextView.setText(title);
        descTextView.setText(description);
        dateTextView.setText(date);
    }

}
