package com.mkgrimaldos.punkapidemo.data.service

import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApiService {
    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int): Response<List<BeerDetailsApi>>
}