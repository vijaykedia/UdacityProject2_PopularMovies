package com.kediavijay.popularmovies.model;

import com.kediavijay.popularmovies.model.pojo.Movie;
import com.kediavijay.popularmovies.model.pojo.MovieDiscoveryResult;

import junit.framework.Assert;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import rx.observers.TestSubscriber;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class MovieProviderTest {

    public MovieProviderTest() {
    }

    @Test
    public void testGetPopularMoviesId() throws IOException {

        final TestSubscriber<MovieDiscoveryResult> testMovieIdSubscriber = new TestSubscriber<>();

        final MovieProvider provider = new MovieProvider();
        provider.getPopularMoviesId(1).subscribe(testMovieIdSubscriber);

        testMovieIdSubscriber.assertNoErrors();

        final List<MovieDiscoveryResult> results = testMovieIdSubscriber.getOnNextEvents();
        Assert.assertTrue(results.size() == 1);

        final MovieDiscoveryResult discoveryResult = results.get(0);
        Assert.assertTrue(!discoveryResult.results.isEmpty());

        for (final MovieDiscoveryResult.MovieId movieId : discoveryResult.results) {

            final TestSubscriber<Movie> movieTestSubscriber = new TestSubscriber<>();

            provider.getMovie(movieId.id).subscribe(movieTestSubscriber);

            movieTestSubscriber.assertNoErrors();
            final List<Movie> movieList = movieTestSubscriber.getOnNextEvents();

            Assert.assertTrue(movieList.size() == 1);
            final Movie movie = movieList.get(0);
        }



//                new Observer<List<MovieDiscoveryResult.MovieId>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(List<MovieDiscoveryResult.MovieId> movieIds) {
//
//                for (final MovieDiscoveryResult.MovieId movieId : movieIds) {
//                    final Observable<Movie> movieObservable = provider.getMovie(movieId.id);
//                    movieObservable.subscribeOn(Schedulers.io()).subscribe(new Observer<Movie>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onNext(Movie movie) {
//                            Assert.assertTrue(movie != null);
//                            System.out.println(movie);
//                        }
//                    });
//                }
//            }
//        };

    }
}
