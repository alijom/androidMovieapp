package com.example.jabirmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    public TextView movieName, releaseDate, movieDescription;
    public ImageView detPict, DetbackDrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movieName=(TextView) findViewById(R.id.detName);
        releaseDate=(TextView) findViewById(R.id.detDate);
        movieDescription=(TextView) findViewById(R.id.movieDescription);
        detPict=(ImageView) findViewById(R.id.poster);
        DetbackDrop=(ImageView) findViewById(R.id.backDrop);

        Picasso.get().load(getIntent().getExtras().getString("backdrop_path")).into(DetbackDrop);
        Picasso.get().load(getIntent().getExtras().getString("poster_path")).into(detPict);

        movieName.setText(getIntent().getExtras().getString("original_title"));
        releaseDate.setText(getIntent().getExtras().getString("release_date"));
        movieDescription.setText(getIntent().getExtras().getString("overview"));





    }
}
