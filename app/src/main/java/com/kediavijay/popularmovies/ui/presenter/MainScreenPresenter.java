package com.kediavijay.popularmovies.ui.presenter;

import android.support.annotation.NonNull;

import com.kediavijay.popularmovies.model.MovieProvider;
import com.kediavijay.popularmovies.ui.screen_contracts.MainScreen;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class MainScreenPresenter {

    private final MovieProvider provider;
    private Realm realm = null;

    @Inject
    public MainScreenPresenter(@NonNull final MovieProvider provider) {
        this.provider = provider;
    }

    /**
     * Called during OnCreate() of {@link com.kediavijay.popularmovies.ui.activties.MainScreenActivity}
     */
    public void onCreate() {
        realm = Realm.getDefaultInstance();
    }

    public void onRetryClick(@NonNull final MainScreen mainScreen) {

    }

    /**
     *
     * @param mainScreen
     */
    public void onNetworkChange(@NonNull final MainScreen mainScreen) {

    }

    public void loadMoreMovies() {

    }

    public void loadMovies(@NonNull final MainScreen mainScreen) {

        mainScreen.showProgressBar();



    }

}
