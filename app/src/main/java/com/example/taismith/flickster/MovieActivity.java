package com.example.taismith.flickster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.taismith.flickster.adapters.MovieAdapter;
import com.example.taismith.flickster.model.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MovieActivity extends AppCompatActivity {

    private static final String MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    List<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
       RecyclerView rvView =   findViewById(R.id.rvView);
       movies = new ArrayList<>();
         final MovieAdapter adapter = new MovieAdapter(this,movies); //this refers to MovieActivity
        rvView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)); // add LM to RV so RV knows how to put items on screen
        rvView.setAdapter(adapter);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(MOVIE_URL, new JsonHttpResponseHandler() {    //callback method
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray movieJSonArray = response.getJSONArray("results");
                    movies.addAll(Movie.fromJsonArray(movieJSonArray));
                    adapter.notifyDataSetChanged();
                    Log.d("hello",movies.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
        }
}
