package com.mkgrimaldos.punkapidemo.domain.usecase

import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

interface SetBeerDetailsUseCase {
    suspend operator fun invoke(beerDetails: BeerDetails)
}