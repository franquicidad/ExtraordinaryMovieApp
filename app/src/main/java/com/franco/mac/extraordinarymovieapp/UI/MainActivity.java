package com.franco.mac.extraordinarymovieapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.franco.mac.extraordinarymovieapp.API.RetrofitBuilder;
import com.franco.mac.extraordinarymovieapp.Adapter.CoverFlowAdapter;
import com.franco.mac.extraordinarymovieapp.Adapter.MovieAdapter;
import com.franco.mac.extraordinarymovieapp.Common.Common;
import com.franco.mac.extraordinarymovieapp.Model.GameEntity;
import com.franco.mac.extraordinarymovieapp.Model.Movie;
import com.franco.mac.extraordinarymovieapp.Model.MoviesList;
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
    //TextSwitcher mTitle;
    private ArrayList<Movie> mMovieArraylist;
    Movie movie;

//_____________________________________________
private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

//        mMovieArraylist= new ArrayList<>();
//
//        adapter=new MovieAdapter(this);
//        mTitle=(TextSwitcher)findViewById(R.id.title);
//
//        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
//                TextView name= (TextView)inflater.inflate(R.layout.layout_title,null);
//
//                return name;
//            }
//        });
//        coverFlow=(FeatureCoverFlow)findViewById(R.id.coverflow);
//        coverFlow.setAdapter(adapter);
//
//            coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
//                @Override
//                public void onScrolledToPosition(int position) {
//                    mTitle.setText(Common.movieList.get(position).getMovieName());
//
//                }
//
//                @Override
//                public void onScrolling() {
//
//                }
//            });
//            coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent =new Intent(MainActivity.this,DetailMovie.class);
//                    intent.putExtra("movie_index_clicked",position);
//                    startActivity(intent);
//                }
//            });
//
GetData();




        //-----------------------------------------------------------------


        mData.add(new GameEntity(R.mipmap.ic_launcher, R.string.title1));
        mData.add(new GameEntity(R.mipmap.ic_launcher, R.string.title2));
        mData.add(new GameEntity(R.mipmap.ic_launcher, R.string.title3));
        mData.add(new GameEntity(R.mipmap.ic_launcher, R.string.title4));

        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                TextView textView = (TextView) inflater.inflate(R.layout.layout_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });


    }

    private void GetData(){
        RetrofitBuilder retrofitBuilder=new RetrofitBuilder();
        Call<MoviesList> movieResultCallback = retrofitBuilder.getMovie();
        movieResultCallback.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                Log.d("Datos",response.toString());
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {

            }
        });

    }


}
