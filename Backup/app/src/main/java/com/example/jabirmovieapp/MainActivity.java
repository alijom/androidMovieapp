package com.example.jabirmovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.jabirmovieapp.Adapter.Adapter;
import com.example.jabirmovieapp.Api.Client;
import com.example.jabirmovieapp.Api.Service;
import com.example.jabirmovieapp.Model.moviesModel;
import com.example.jabirmovieapp.Model.moviesResponceModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private List<moviesModel> movielist;
    public static final String LOG_TAG = Adapter.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.movieList);
        movielist= new ArrayList<>();
        Adapter adapter = new Adapter(MainActivity.this,movielist);

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        getDataFromJson();

        //getDataFromApi();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        Api api = retrofit.create(Api.class);
//
//        Call<List<moviesModel>> call = api.getMovies();
//        call.enqueue(new Callback<List<moviesModel>>() {
//            @Override
//            public void onResponse(Call<List<moviesModel>> call, Response<List<moviesModel>> response) {
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<moviesModel>> call, Throwable t) {
//
//            }
//        });


    }

    private void getDataFromJson() {

        try {
            Client client = new Client();
            Service apiService = Client.getClient().create(Service.class);

            Call<moviesResponceModel> call= apiService.getNowPlaying(BuildConfig.MOVIE_API_TOKEN);
            call.enqueue(new Callback<moviesResponceModel>() {
                @Override
                public void onResponse(Call<moviesResponceModel> call, retrofit2.Response<moviesResponceModel> response) {
                   List<moviesModel> movies= response.body().getResults();
                    Collections.sort(movies,moviesModel.BY_NAME_ALPHABETICAL);
                   recyclerView.setAdapter(new Adapter(getApplicationContext(),movies));



                }

                @Override
                public void onFailure(Call<moviesResponceModel> call, Throwable t) {
                   Log.d("error",t.getMessage());
                    Toast.makeText(MainActivity.this,"error"+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        catch (Exception e) {
                    e.printStackTrace();
                }
    }

    private void getDataFromApi() {
        String url ="https://api.themoviedb.org/3/movie/now_playing?api_key=e7552447fd412cbf197543428dd94faf&language=en-US&page=1";
        JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<moviesModel>>(){}.getType();
                movielist = gson.fromJson(response.toString(),type);

                Adapter adapter = new Adapter(MainActivity.this,movielist);
                recyclerView.setAdapter(adapter);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getCause() + "", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(MainActivity.this).add(request);
    }

//    @Override
//    public void onMovieClicked(int position) {
//    Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_SHORT).show();
//    }
}
