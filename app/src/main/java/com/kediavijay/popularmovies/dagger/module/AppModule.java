package com.kediavijay.popularmovies.dagger.module;

import android.support.annotation.NonNull;

import com.kediavijay.popularmovies.model.MovieProvider;
import com.kediavijay.popularmovies.ui.presenter.MainScreenPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    @NonNull
    public MovieProvider getDataProvider() {
        return new MovieProvider();
    }

    @Provides
    @Singleton
    @NonNull
    public MainScreenPresenter providesMainScreenPresenter(@NonNull final MovieProvider provider) {
        return new MainScreenPresenter(provider);
    }
}
