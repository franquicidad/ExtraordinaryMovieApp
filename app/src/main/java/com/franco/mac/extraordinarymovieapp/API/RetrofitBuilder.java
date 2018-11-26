package com.franco.mac.extraordinarymovieapp.API;

import android.util.Log;

import com.franco.mac.extraordinarymovieapp.BuildConfig;
import com.franco.mac.extraordinarymovieapp.Model.Movie;
import com.franco.mac.extraordinarymovieapp.Model.MoviesList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitBuilder {

    final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor())
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .build();

  public Call<MoviesList>getMovie(){

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipesInterface recipesInterface=retrofit.create(RecipesInterface.class);

        return recipesInterface.getMoviesTask();



    }
//TODO: (2) Check for the Api key why is being erased when i create the project!
    public interface RecipesInterface{
    @GET("popular")
        Call<MoviesList> getMoviesTask();
    }

    public static class LoggingInterceptor implements Interceptor {
        @Override public okhttp3.Response intercept(Chain chain) throws IOException {

            HttpUrl url = chain.request().url()
                    .newBuilder()
                    .addQueryParameter("api_key", "7d51874568317dfd0c91db399be2bdec")
                    .build();

            Request request = chain.request().newBuilder().url(url).build();;

            long t1 = System.nanoTime();
            String requestLog = String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers());
            //YLog.d(String.format("Sending request %s on %s%n%s",
            //        request.url(), chain.connection(), request.headers()));
            if(request.method().compareToIgnoreCase("post")==0){
                requestLog ="\n"+requestLog+"\n"+bodyToString(request);
            }
            Log.d("TAG","request"+"\n"+requestLog);

            okhttp3.Response response = chain.proceed(request);
            long t2 = System.nanoTime();

            String responseLog = String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers());

            String bodyString = response.body().string();

            Log.d("TAG","response"+"\n"+responseLog+"\n"+bodyString);

            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
            //return response;
        }
    }
    private static String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (copy != null && copy.body() != null) // make sure its not null to avoif NPE
                copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

}
