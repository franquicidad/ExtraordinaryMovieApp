package com.franco.mac.extraordinarymovieapp.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.franco.mac.extraordinarymovieapp.Common.Common;
import com.franco.mac.extraordinarymovieapp.Model.Movie;
import com.franco.mac.extraordinarymovieapp.R;
import com.franco.mac.extraordinarymovieapp.Urls;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.squareup.picasso.Picasso;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailMovie extends AppCompatActivity {


    @BindView(R.id.movie_image)
    KenBurnsView movieImage;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.diagonalLayout)
    DiagonalLayout diagonalLayout;
    @BindView(R.id.movie_summary)
    TextView movieSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            int movie_index = getIntent().getIntExtra("movie_index_clicked", -1);
            if (movie_index != -1) {
                loadMovieDetail(movie_index);
            }
        }
    }

    private void loadMovieDetail(int index) {
        Movie movie = Common.movieList.get(index);



        Glide.with(getApplicationContext()).load(movie.getPoster_path()).into(movieImage);
        movieTitle.setText(movie.getTitle());
        movieSummary.setText(movie.getOverview());
    }
}
