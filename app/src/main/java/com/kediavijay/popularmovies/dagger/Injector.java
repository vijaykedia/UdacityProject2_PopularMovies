package com.kediavijay.popularmovies.dagger;

import com.kediavijay.popularmovies.dagger.component.AppComponent;
import com.kediavijay.popularmovies.dagger.component.DaggerAppComponent;
import com.kediavijay.popularmovies.dagger.module.AppModule;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class Injector {

    private static AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
