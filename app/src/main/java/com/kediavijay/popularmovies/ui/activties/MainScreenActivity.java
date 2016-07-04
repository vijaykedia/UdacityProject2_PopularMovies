package com.kediavijay.popularmovies.ui.activties;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.kediavijay.popularmovies.R;
import com.kediavijay.popularmovies.dagger.Injector;
import com.kediavijay.popularmovies.ui.presenter.MainScreenPresenter;
import com.kediavijay.popularmovies.ui.screen_contracts.MainScreen;
import com.kediavijay.popularmovies.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class MainScreenActivity extends AppCompatActivity implements MainScreen {

    private static final String LOG_TAG = MainScreenActivity.class.getSimpleName();

    // ---- Views ----
    @BindView(R.id.main_screen_coordinator_layout)
    public CoordinatorLayout coordinatorLayout;

    @BindView(R.id.main_screen_toolbar)
    public Toolbar toolbar;

    public RecyclerView recyclerView;

    private Snackbar snackbar;

    private BroadcastReceiver broadcastReceiver;

    // ---- Variables ----
    private MainScreenPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {

        Util.DebugLog(LOG_TAG, "onCreate() -- MainScreenActivity is being created");

        super.onCreate(savedInstanceState);

        // Inflate layout file
        setContentView(R.layout.main_screen_activity_layout);

        // Bind Views and Inject dependencies
        ButterKnife.bind(this);
        Injector.getAppComponent().inject(this);

        presenter.onCreate();

        // Initialize snackBar (interactive UI element to show error message) with arbitrary text
        snackbar = Snackbar.make(coordinatorLayout, "Temp", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("RETRY", v -> {
            presenter.onRetryClick(getScreen());
        });

        // Initialize broadcast receiver
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(@NonNull final Context context, @NonNull final Intent intent) {

                if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                    presenter.onNetworkChange(getScreen());
                }
            }
        };

//        // Set up RecyclerView
//        int columnCount = getResources().getInteger(R.integer.list_column_count);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL));
//
//        adapter = new MovieListAdapter(this, null, this);
//        recyclerView.setAdapter(adapter);



    }

    //
    public void showProgressBar() {

    }

    // ---- Helper Methods ----
    private MainScreen getScreen() {
        return this;
    }
}
