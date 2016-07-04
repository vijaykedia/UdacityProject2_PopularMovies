package com.kediavijay.popularmovies.model.pojo;

import android.support.annotation.NonNull;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class Movie extends RealmObject {

    public int id;

    public String imdb_id;

    public String original_title;

    public String overview;

    public String poster_path;

    public String backdrop_path;

    public double popularity;

    public int runtime;

    public String tagline;

    public double vote_average;

    public int vote_count;

    public String release_date;

    public RealmList<Genre> genres;

    public RealmList<ProductionCompanies> production_companies;

    public ReviewResult reviews;

    public TrailerResult videos;

    @NonNull
    public RealmList<Review> getReviews() {
        return reviews.reviewList;
    }
}
