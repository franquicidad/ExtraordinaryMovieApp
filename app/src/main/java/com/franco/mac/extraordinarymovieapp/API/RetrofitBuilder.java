package com.franco.mac.extraordinarymovieapp.API;

import com.franco.mac.extraordinarymovieapp.BuildConfig;
import com.franco.mac.extraordinarymovieapp.Model.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitBuilder {

    public static Call<ArrayList<Movie>> getMovie(){

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipesInterface recipesInterface=retrofit.create(RecipesInterface.class);

        return recipesInterface.getMoviesTask();



    }
//TODO: (2) Check for the Api key why is being erased when i create the project!
    public interface RecipesInterface{
        @GET("top_rated?api_key="+ BuildConfig.movieDbApiKey)
        Call<ArrayList<Movie>> getMoviesTask();
    }

}
