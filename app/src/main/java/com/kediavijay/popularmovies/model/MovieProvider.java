package com.kediavijay.popularmovies.model;

import android.support.annotation.NonNull;

import com.kediavijay.popularmovies.BuildConfig;
import com.kediavijay.popularmovies.model.pojo.Movie;
import com.kediavijay.popularmovies.model.pojo.MovieDiscoveryResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import rx.Observable;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class MovieProvider {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private static final Map<String, String> AUTH = Collections.singletonMap("api_key", BuildConfig.TMDB_API_KEY);

    private final TMDBService tmdbService;

    public MovieProvider() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        tmdbService = retrofit.create(TMDBService.class);
    }

    @NonNull
    public Observable<MovieDiscoveryResult> getPopularMoviesId(final int pageNumber) {

        final Map<String, String> queryParams = new HashMap<>();
        queryParams.putAll(AUTH);
        queryParams.put("page", Integer.toString(pageNumber));

        return tmdbService.getPopularMovies(queryParams);
    }

    @NonNull
    public Observable<MovieDiscoveryResult> getTopRatedMovies(final int pageNumber) {

        final Map<String, String> queryParams = new HashMap<>();
        queryParams.putAll(AUTH);
        queryParams.put("page", Integer.toString(pageNumber));

        return tmdbService.getTopRatedMovies(queryParams);
    }

    @NonNull
    public Observable<Movie> getMovie(final int movieId) {

        final Map<String, String> queryParams = new HashMap<>();
        queryParams.putAll(AUTH);
        queryParams.put("append_to_response", "reviews,videos");

        return tmdbService.getMovie(movieId, queryParams);
    }
}
