package com.mkgrimaldos.punkapidemo.domain.usecase

import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository

class SetBeerDetailsUseCaseImpl(private val beerRepository: BeerRepository) :
    SetBeerDetailsUseCase {
    override suspend fun invoke(beerDetails: BeerDetails) {
        beerRepository.setBeerDetails(beerDetails)
    }
}