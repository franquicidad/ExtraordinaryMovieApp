package com.franco.mac.extraordinarymovieapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.franco.mac.extraordinarymovieapp.API.RetrofitBuilder;
import com.franco.mac.extraordinarymovieapp.Adapter.MovieAdapter;
import com.franco.mac.extraordinarymovieapp.Common.Common;
import com.franco.mac.extraordinarymovieapp.Model.Movie;
import com.franco.mac.extraordinarymovieapp.R;
import com.franco.mac.extraordinarymovieapp.Urls;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;
    private ArrayList<Movie> mMovieArraylist;
    Movie movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
          initData();



        adapter=new MovieAdapter(mMovieArraylist,this);
        mTitle=(TextSwitcher)findViewById(R.id.mtitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                TextView name= (TextView)inflater.inflate(R.layout.layout_title,null);

                return name;
            }
        });
        coverFlow=(FeatureCoverFlow)findViewById(R.id.coverFlow);
        coverFlow.setAdapter(adapter);

            coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
                @Override
                public void onScrolledToPosition(int position) {
                    mTitle.setText(Common.movieList.get(position).getMovieName());

                }

                @Override
                public void onScrolling() {

                }
            });
            coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent =new Intent(MainActivity.this,DetailMovie.class);
                    intent.putExtra("movie_index_clicked",position);
                    startActivity(intent);
                }
            });

    }

    private void initData() {


        Call<ArrayList<Movie>> arrayListCall= RetrofitBuilder.getMovie();
        arrayListCall.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
               
                mMovieArraylist=response.body();
                adapter.setMovieData(mMovieArraylist);


            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {

            }
        });

//        Movie movie1=new Movie("Spiderman: Homecoming", Urls.spiderman,String.valueOf(R.string.spiderman));
//        Common.movieList.add(movie1);
//
//        Movie movie2=new Movie("Avengers: Infinity War",Urls.AvengersInfinity,String.valueOf(R.string.spiderman));
//        Common.movieList.add(movie2);
//
//        Movie movie3=new Movie("Captain America:Civil War",Urls.Civil_war,String.valueOf(R.string.spiderman));
//        Common.movieList.add(movie3);
//
//        Movie movie4=new Movie("Antman and the Wasp",Urls.Antman,String.valueOf(R.string.spiderman));
//        Common.movieList.add(movie4);



    }
}
