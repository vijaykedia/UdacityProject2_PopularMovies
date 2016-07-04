package com.kediavijay.popularmovies;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by vijaykedia on 01/06/16.
 * This will extend the base application
 */
public class PopularMoviesApplication extends Application {

    public static boolean isDebug = false;

    private static PopularMoviesApplication sInstance;

    public static synchronized PopularMoviesApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        isDebugOrReleaseMode();

        if (isDebug) {
            Stetho.initializeWithDefaults(getApplicationContext());
        }

        RealmConfiguration config = new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

    }

    private void isDebugOrReleaseMode() {
        final String packageName = BuildConfig.APPLICATION_ID;
        isDebug = packageName.endsWith("debug");
    }
}
