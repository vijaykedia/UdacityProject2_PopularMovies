package com.kediavijay.popularmovies.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;

import com.kediavijay.popularmovies.PopularMoviesApplication;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class Util {

    public static void DebugLog(@NonNull final String tag, @NonNull final String message) {
        if (PopularMoviesApplication.isDebug) {
            Log.d(tag, message);
        }
    }

    public static boolean isNetworkAvailable(@NonNull final Context context) {

        final ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        return !(networkInfo == null || !networkInfo.isConnected());
    }
}
