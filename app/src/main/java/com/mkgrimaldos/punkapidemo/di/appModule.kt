package com.mkgrimaldos.punkapidemo.di

import androidx.room.Room
import com.mkgrimaldos.punkapidemo.data.database.BeerDatabase
import com.mkgrimaldos.punkapidemo.data.database.BeerDetailsDAO
import com.mkgrimaldos.punkapidemo.data.repository.BeerRepositoryImpl
import com.mkgrimaldos.punkapidemo.data.service.PunkApi
import com.mkgrimaldos.punkapidemo.data.service.PunkApiService
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository
import com.mkgrimaldos.punkapidemo.domain.usecase.GetBeerListUseCase
import com.mkgrimaldos.punkapidemo.domain.usecase.GetBeerListUseCaseImpl
import com.mkgrimaldos.punkapidemo.domain.usecase.SetBeerDetailsUseCase
import com.mkgrimaldos.punkapidemo.domain.usecase.SetBeerDetailsUseCaseImpl
import com.mkgrimaldos.punkapidemo.ui.beerdetails.BeerDetailsViewModel
import com.mkgrimaldos.punkapidemo.ui.beerlist.BeerListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { BeerListViewModel(get()) }

    viewModel { (beerDetails: BeerDetails) -> BeerDetailsViewModel(beerDetails, get()) }

    factory<GetBeerListUseCase> {
        GetBeerListUseCaseImpl(get())
    }

    factory<SetBeerDetailsUseCase> {
        SetBeerDetailsUseCaseImpl(get())
    }

    single<BeerRepository> {
        BeerRepositoryImpl(get(), get())
    }

    single<PunkApiService> {
        PunkApi().createServiceApi()
    }

    single<BeerDatabase> {
        Room.databaseBuilder(androidApplication(), BeerDatabase::class.java, "beer_db").build()
    }

    single<BeerDetailsDAO> {
        get<BeerDatabase>().beerDao()
    }
}