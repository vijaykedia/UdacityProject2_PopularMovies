package com.kediavijay.popularmovies.model;

import com.kediavijay.popularmovies.model.pojo.Movie;
import com.kediavijay.popularmovies.model.pojo.MovieDiscoveryResult;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public interface TMDBService {

    @GET("movie/popular")
    Observable<MovieDiscoveryResult> getPopularMovies(@QueryMap Map<String, String> options);

    @GET("movie/top_rated")
    Observable<MovieDiscoveryResult> getTopRatedMovies(@QueryMap Map<String, String> options);

    @GET("movie/{id}")
    Observable<Movie> getMovie(@Path("id") int movieId, @QueryMap Map<String, String> options);
}
