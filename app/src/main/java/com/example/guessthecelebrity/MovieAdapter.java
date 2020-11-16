package com.example.guessthecelebrity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter {

    List list = new ArrayList();


    public MovieAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{
        ImageView Poster;
        TextView title;
        TextView rating;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;

        DataHandler dataHandler;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);

            dataHandler = new DataHandler();
            dataHandler.Poster = (ImageView) row.findViewById(R.id.movie_poster);
            dataHandler.title = (TextView) row.findViewById(R.id.movie_title);
            dataHandler.rating = (TextView) row.findViewById(R.id.movie_rating);

            row.setTag(dataHandler);
        }
        else{
            dataHandler = (DataHandler) row.getTag();
        }

        MovieDataProvider dataProvider;
        dataProvider = (MovieDataProvider) this.getItem(position);

        dataHandler.Poster.setImageResource(dataProvider.getMovie_poster_resource());
        dataHandler.title.setText(dataProvider.getMovie_title());
        dataHandler.rating.setText(dataProvider.getMovie_rating());


        return row;
    }
}
