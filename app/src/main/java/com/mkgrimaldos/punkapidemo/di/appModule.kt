package com.mkgrimaldos.punkapidemo.di

import com.mkgrimaldos.punkapidemo.data.repository.BeerRepositoryImpl
import com.mkgrimaldos.punkapidemo.data.service.PunkApi
import com.mkgrimaldos.punkapidemo.data.service.PunkApiService
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository
import com.mkgrimaldos.punkapidemo.domain.usecase.GetBeerListUseCase
import com.mkgrimaldos.punkapidemo.domain.usecase.GetBeerListUseCaseImpl
import com.mkgrimaldos.punkapidemo.ui.beerlist.BeerListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { BeerListViewModel(get()) }

    factory<GetBeerListUseCase> {
        GetBeerListUseCaseImpl(get())
    }

    single<BeerRepository> {
        BeerRepositoryImpl(get())
    }

    single<PunkApiService> {
        PunkApi().createServiceApi()
    }
}