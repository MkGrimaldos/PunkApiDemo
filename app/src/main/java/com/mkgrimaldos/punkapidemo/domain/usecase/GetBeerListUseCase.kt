package com.mkgrimaldos.punkapidemo.domain.usecase

import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

interface GetBeerListUseCase {
    suspend operator fun invoke(): Result<List<BeerDetails>>
}