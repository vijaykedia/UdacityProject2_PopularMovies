package com.kediavijay.popularmovies.event;

import android.support.annotation.NonNull;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 * This will be used to pass {@link String} error message
 */
public class ErrorMessageEvent {

    private final String message;

    public ErrorMessageEvent(@NonNull final String message) {
        this.message = message;
    }

    @NonNull
    public String getMessage() {
        return message;
    }
}
