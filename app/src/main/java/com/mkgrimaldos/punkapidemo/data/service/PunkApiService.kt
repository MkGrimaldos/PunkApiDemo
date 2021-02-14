package com.mkgrimaldos.punkapidemo.data.service

import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import retrofit2.Response
import retrofit2.http.GET

interface PunkApiService {
    @GET("beers/")
    suspend fun getBeers(): Response<List<BeerDetailsApi>>
}