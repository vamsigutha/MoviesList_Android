package com.example.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] movie_poster_resource = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
            R.drawable.movie4, R.drawable.movie5, R.drawable.movie6, R.drawable.movie7,
            R.drawable.movie8, R.drawable.movie9, R.drawable.movie10};

    String[] movie_titles;
    String[] movie_ratings;

    MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        movie_titles = getResources().getStringArray(R.array.movie_titles);
        movie_ratings = getResources().getStringArray(R.array.movie_ratings);
        int i=0;
        movieAdapter = new MovieAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(movieAdapter);
        for(String titles:movie_titles){
            MovieDataProvider movieDataProvider = new MovieDataProvider(movie_poster_resource[i],titles,movie_ratings[i]);
            movieAdapter.add(movieDataProvider);
            i++;
        }
    }
}