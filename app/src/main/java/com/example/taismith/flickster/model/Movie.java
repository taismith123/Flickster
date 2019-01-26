package com.example.taismith.flickster.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
private String posterPath;
private String title;
private String overView;
private String backdropPath;
private double voteAvg;
int movieId;
private String releaseDate;
private String originalLanguage;
private double popularity;

    public Movie() {    // empty constructor needed by the Parceler library
    }

    public Movie(JSONObject jsonObject) throws JSONException {
    posterPath = (jsonObject.getString("poster_path"));
    title = (jsonObject.getString("title"));
    overView =(jsonObject.getString("overview"));
    voteAvg = (jsonObject.getDouble("vote_average"));
    movieId= jsonObject.getInt("id");
    backdropPath = jsonObject.getString("backdrop_path");
    releaseDate = jsonObject.getString("release_date");
    originalLanguage = jsonObject.getString("original_language");
    popularity = jsonObject.getDouble("popularity");
    }



    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
    List<Movie> movies = new ArrayList<>();
for (int i =0; i< movieJsonArray.length(); i++){
    movies.add(new Movie(movieJsonArray.getJSONObject(i)));  //populate movies
}
return movies;
}


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }
    public String getTitle() {
        return title;
    }



    public String getOverView() {
        return overView;
    }


    public double getVoteAvg() {
        return voteAvg;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public String getOriginalLanguage(){
        return originalLanguage;
    }

    public double getPopularity(){
        return popularity;
    }
}

