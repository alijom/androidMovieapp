package com.example.jabirmovieapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jabirmovieapp.DetailActivity;
import com.example.jabirmovieapp.Model.moviesModel;
import com.example.jabirmovieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.movieViewholder> {
    Context mContext;
    List<moviesModel> model;
    //OnMovieClickListener listener;

    public Adapter(Context mContext, List<moviesModel> model) {
        this.mContext = mContext;
        this.model = model;

    }

    @NonNull
    @Override
    public movieViewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent,false);
        return new movieViewholder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter.movieViewholder movieHolder, int position) {

    moviesModel currentItem = model.get(position);

    movieHolder.movieName.setText(currentItem.getOriginal_title());
    String vote= Double.toString(currentItem.getVote_average());
    movieHolder.movieDescription.setText(vote);
    movieHolder.releaseDate.setText(currentItem.getRelease_date());
    Picasso.get().load(currentItem.getPoster_path()).into(movieHolder.moviePict);


    }

    @Override
    public int getItemCount() {
        return model.size() ;
    }


    public class movieViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView movieName, releaseDate, movieDescription;
        public ImageView moviePict, viewDetails;
        //private ItemClickListener itemClickListener;

        public movieViewholder(@NonNull View itemView) {
            super(itemView);

            moviePict = (ImageView) itemView.findViewById(R.id.pic);
            viewDetails = (ImageView) itemView.findViewById(R.id.viewDetails);
            releaseDate = (TextView) itemView.findViewById(R.id.releaseDate);
            movieName = (TextView) itemView.findViewById(R.id.movieName);
            movieDescription = (TextView) itemView.findViewById(R.id.movieDescription);

            viewDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("original_title",model.get(position).getOriginal_title());
                    intent.putExtra("poster_path",model.get(position).getPoster_path());
                    intent.putExtra("backdrop_path",model.get(position).getBackdrop_path());
                    intent.putExtra("overview",model.get(position).getOverview());
                    intent.putExtra("vote_average",Double.toString(model.get(position).getVote_average()));
                    intent.putExtra("release_date",model.get(position).getRelease_date());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                    Toast.makeText(v.getContext(),"View details for " +model.get(position).getTitle(),Toast.LENGTH_SHORT).show();

                }
            });
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            //listener.onMovieClicked(position);

            //itemClickListener.onClick(v,getAdapterPosition(), false);

        }

//        public void setItemClickListener(ItemClickListener itemClickListener) {
//            this.itemClickListener = itemClickListener;
//        }
    }

}
