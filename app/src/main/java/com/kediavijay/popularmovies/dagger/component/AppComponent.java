package com.kediavijay.popularmovies.dagger.component;

import com.kediavijay.popularmovies.dagger.module.AppModule;
import com.kediavijay.popularmovies.ui.activties.MainScreenActivity;
import com.kediavijay.popularmovies.ui.fragments.MovieDetailFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(final MainScreenActivity mainScreenActivity);

    void inject(final MovieDetailFragment detailFragment);
}
