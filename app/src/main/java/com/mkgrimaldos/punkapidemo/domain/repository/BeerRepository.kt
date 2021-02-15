package com.mkgrimaldos.punkapidemo.domain.repository

import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

interface BeerRepository {
    suspend fun getBeerList(): Result<BeerDetails>
}