package com.kediavijay.popularmovies.model.pojo;

import java.util.List;

/**
 * Copyright (c) 2016 vijaykedia (vijaykedia1987@gmail.com) All rights reserved.
 */
public class MovieDiscoveryResult {

    public int page;

    public List<MovieId> results;

    public int total_pages;

    public int total_results;

    public class MovieId {

        public int id;

    }
}
