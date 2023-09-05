package com.example.nasasearchengine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<SearchResult> searchResults;

    public RecyclerViewAdapter(Context context, ArrayList<SearchResult> searchResults, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.searchResults = searchResults;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assign values to each row
        holder.textview.setText(searchResults.get(position).getTitle());
        Picasso.get().load(searchResults.get(position).getImage()).into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        //how many items to display
        return searchResults.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //like a "onCreate" method
        ImageView imageview;
        TextView textview;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageView);
            textview = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onClick(pos);
                        }
                    }
                }
            });
        }
    }
}
