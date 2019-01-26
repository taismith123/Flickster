package com.example.taismith.flickster.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.taismith.flickster.DetailActivity;
import com.example.taismith.flickster.R;
import com.example.taismith.flickster.model.Movie;

import org.parceler.Parcels;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>  {

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    //USING THE RECYCLER VIEW
    //Add RecyclerView support library to the gradle build file
    //Define a model class to use as the data source
    //Add a RecyclerView to your activity to display the items
    //Create a custom row layout XML file to visualize the item
    //Create a RecyclerView.Adapter and ViewHolder to render the item
    //Bind the adapter to the data source to populate the RecyclerView

    Context context;
    List<Movie> movies;





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //responsible for inflating itemmovieXML
       View view= LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Movie movie = movies.get(position);
   // Bind the movie data into the view holder
        holder.bind(movie);
    }


    @Override
    public int getItemCount() {  // tells recycler view how many items are in data set
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView ivTitle;
        TextView ivOverview;
        ImageView ivPoster;
        RelativeLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTitle = itemView.findViewById(R.id.ivTitle);
            ivOverview = itemView.findViewById(R.id.ivOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container= itemView.findViewById(R.id.container);
        }

        public void bind(final Movie movie) {
        ivTitle.setText(movie.getTitle());
        ivOverview.setText(movie.getOverView());
        //reference the backdrop path if phone is in landscape
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);

           // String imageURL = movie.getPosterPath();
           // if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //    imageURL= movie.getBackdropPath();
           // }


        // add a  click lisener on entire row

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to detail activity on tap
                Intent i = new Intent(context, DetailActivity.class);

               // Toast.makeText(context, movie.getTitle(),Toast.LENGTH_SHORT).show();

                i.putExtra("movie", Parcels.wrap(movie)); //pass in a parceable(movie object)
                context.startActivity(i);
            }
        });
        }
    }
}
