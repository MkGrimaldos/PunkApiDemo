package com.mkgrimaldos.punkapidemo.domain.usecase

import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository

class GetBeerListUseCaseImpl(private val beerRepository: BeerRepository) : GetBeerListUseCase {
    override suspend operator fun invoke(): Result<BeerDetails> {
        return beerRepository.getBeerList()
    }
}