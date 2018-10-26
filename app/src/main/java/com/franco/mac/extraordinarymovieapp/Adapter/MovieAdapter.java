package com.franco.mac.extraordinarymovieapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.franco.mac.extraordinarymovieapp.Model.Movie;
import com.franco.mac.extraordinarymovieapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private ArrayList<Movie> movieList;
    private Context context;

    public Movie movie;

    public MovieAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }



    public void setMovieData(ArrayList<Movie> movieData){
        movieList=movieData;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        if(movieList ==null){
            return 0;
        }else {
            return movieList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView=convertView;

        if(rootView==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.layout_item, null);

            TextView name = (TextView) view.findViewById(R.id.label);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);

            Glide.with(context).load(movieList.get(position).getPoster_path()).into(imageView);
            name.setText(movieList.get(position).getMovieName());

            return view;
        }

        return rootView;

        }
}
