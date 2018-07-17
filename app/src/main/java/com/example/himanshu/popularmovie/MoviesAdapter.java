package com.example.himanshu.popularmovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

        private Context context;
        private List<Movies> list=new ArrayList<>();
        private ImageView imageView;

    public MoviesAdapter(Context context, List<Movies> list) {
        this.context = context;
        this.list = list;
    }

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.recycler_item,viewGroup,false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {

        Picasso.with(context).load(MainActivity.images.get(i)).into(imageView);
        movieViewHolder.setIsRecyclable(false);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.poster_image);
        }
    }
}
