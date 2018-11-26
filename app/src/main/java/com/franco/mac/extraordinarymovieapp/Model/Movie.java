package com.franco.mac.extraordinarymovieapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Movie{
    private String vote_average;

    private String backdrop_path;

    private String adult;

    private String id;

    private String title;

    private String overview;

    private String original_language;

    private String[] genre_ids;

    private String release_date;

    private String original_title;

    private String vote_count;

    private String poster_path;

    private String video;

    private String popularity;

    public String getVote_average ()
    {
        return vote_average;
    }

    public void setVote_average (String vote_average)
    {
        this.vote_average = vote_average;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public void setBackdrop_path (String backdrop_path)
    {
        this.backdrop_path = backdrop_path;
    }

    public String getAdult ()
    {
        return adult;
    }

    public void setAdult (String adult)
    {
        this.adult = adult;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    public String getOriginal_language ()
    {
        return original_language;
    }

    public void setOriginal_language (String original_language)
    {
        this.original_language = original_language;
    }

    public String[] getGenre_ids ()
    {
        return genre_ids;
    }

    public void setGenre_ids (String[] genre_ids)
    {
        this.genre_ids = genre_ids;
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public String getOriginal_title ()
    {
        return original_title;
    }

    public void setOriginal_title (String original_title)
    {
        this.original_title = original_title;
    }

    public String getVote_count ()
    {
        return vote_count;
    }

    public void setVote_count (String vote_count)
    {
        this.vote_count = vote_count;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    public String getVideo ()
    {
        return video;
    }

    public void setVideo (String video)
    {
        this.video = video;
    }

    public String getPopularity ()
    {
        return popularity;
    }

    public void setPopularity (String popularity)
    {
        this.popularity = popularity;
    }

    // Parcelling part

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(this.original_language);
//        dest.writeString(this.original_title);
//        dest.writeString(this.overview);
//        dest.writeString(this.poster_path);
//
//        dest.writeString(this.genre_ids[0]);
//        dest.writeString(this.title);
//        dest.writeString(this.release_date);
//
//        dest.writeString(this.backdrop_path);
//
//        dest.writeInt(this.);
//        dest.writeInt(this.id);
//        dest.writeInt(this.vote_count);
//        dest.writeFloat(this.vote_average);
//        dest.writeFloat(this.popularity);
//
//
//    }
//
//    protected Movie(Parcel in) {
//        this.original_language = in.readString();
//        this.original_title = in.readString();
//        this.overview = in.readString();
//        this.poster_path = in.readString();
//        this.generids = in.readString();
//        this.title = in.readString();
//        this.release_date = in.readString();
//        this.backdrop_path = in.readString();
//
//        this.favourite = in.readInt();
//        this.id = in.readInt();
//        this.vote_count = in.readInt();
//        this.vote_average =in.readFloat();
//        this.popularity = in.readFloat();
//
//    }

//    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
//        public Movie createFromParcel(Parcel source) {
//            return new Movie(source);
//        }
//
//        public Movie[] newArray(int size) {
//            return new Movie[size];
//        }
//    };

//    @Override
//    public int describeContents() {
//        return 0;
//    }
}

