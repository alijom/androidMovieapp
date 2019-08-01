package com.example.jabirmovieapp.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class moviesModel {
    private String title, poster_path, original_language,
            original_title, backdrop_path, overview, release_date;
    private boolean adult, video;
    private List<Integer> genre_ids = new ArrayList<Integer>();
    private Integer id, vote_count;
    private Double popularity, vote_average;

    public moviesModel() {
    }

    public moviesModel(String title, String poster_path, String original_language, String original_title, String backdrop_path, String overview, String release_date, boolean adult, boolean video, List<Integer> genre_ids, Integer id, Integer vote_count, Double popularity, Double vote_average) {
        this.title = title;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
        this.adult = adult;
        this.video = video;
        this.genre_ids = genre_ids;
        this.id = id;
        this.vote_count = vote_count;
        this.popularity = popularity;
        this.vote_average = vote_average;
    }

    public static final Comparator<moviesModel> BY_NAME_ALPHABETICAL = new Comparator<moviesModel>() {
        @Override
        public int compare(moviesModel o1, moviesModel o2) {
            return o1.original_title.compareTo(o2.original_title);
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return "https://image.tmdb.org/t/p/w200"+poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getBackdrop_path() {

        return "https://image.tmdb.org/t/p/w500"+backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }
}
