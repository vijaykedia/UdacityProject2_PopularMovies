package com.kediavijay.popularmovies.model.pojo;

import io.realm.RealmObject;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class Review extends RealmObject {

    public int id;

    public String author;

    public String content;
}
