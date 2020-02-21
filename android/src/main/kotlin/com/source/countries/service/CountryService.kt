package com.source.countries.service

import retrofit2.http.GET

/**
 * @project Countries
 * @author SourceOne on 21.02.2020
 */

interface CountryService{
    @GET("rest/v2/all")
    fun countries()
}