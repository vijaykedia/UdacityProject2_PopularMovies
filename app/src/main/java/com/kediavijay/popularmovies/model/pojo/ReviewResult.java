package com.kediavijay.popularmovies.model.pojo;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class ReviewResult extends RealmObject{

    public int page;

    public RealmList<Review> reviewList;

    public int total_pages;

    public int total_results;

}
