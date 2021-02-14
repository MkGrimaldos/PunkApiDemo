package com.mkgrimaldos.punkapidemo.data.repository

import com.mkgrimaldos.punkapidemo.data.ResponseProcesser
import com.mkgrimaldos.punkapidemo.data.service.PunkApiService
import com.mkgrimaldos.punkapidemo.data.service.mapping.toDomain
import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository

class BeerRepositoryImpl(private val service: PunkApiService) : BeerRepository {
    override suspend fun getBeerList(): Result<List<BeerDetails>> {
        return ResponseProcesser.processResponse(
            { service.getBeers() },
            { it!!.map { beerDetailsApi -> beerDetailsApi.toDomain() } })
    }
}