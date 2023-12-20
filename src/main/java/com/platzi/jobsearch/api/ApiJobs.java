package com.platzi.jobsearch.api;

import java.util.List;
import java.util.Map;

import com.platzi.jobsearch.Character;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

/**
 * ApiJobs
 */
@Headers("Accept: application/json")
public interface ApiJobs {

    @RequestLine("GET /character")
    List<Character> character(@QueryMap Map<String,Object>queryMap);
}