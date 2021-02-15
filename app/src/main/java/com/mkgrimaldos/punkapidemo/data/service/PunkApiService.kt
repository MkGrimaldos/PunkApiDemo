package com.mkgrimaldos.punkapidemo.data.service

import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApiService {
    @GET("beers")
    fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<BeerDetailsApi>>
}