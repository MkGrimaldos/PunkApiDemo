package com.mkgrimaldos.punkapidemo.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mkgrimaldos.punkapidemo.data.database.BeerDetailsDAO
import com.mkgrimaldos.punkapidemo.data.database.mapping.toDB
import com.mkgrimaldos.punkapidemo.data.database.mapping.toDomain
import com.mkgrimaldos.punkapidemo.data.paging.BeerDetailsListBoundaryCallback
import com.mkgrimaldos.punkapidemo.data.paging.PagingConfigParams.PAGE_SIZE
import com.mkgrimaldos.punkapidemo.data.service.PunkApiService
import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository

class BeerRepositoryImpl(
    private val service: PunkApiService,
    private val beerDetailsDAO: BeerDetailsDAO
) : BeerRepository {

    lateinit var beerDetails: LiveData<PagedList<BeerDetails>>
    lateinit var errorMessage: LiveData<String>

    override suspend fun getBeerList(): Result<BeerDetails> {
        val beerDetailsListBoundaryCallback =
            BeerDetailsListBoundaryCallback(service, beerDetailsDAO)

        errorMessage = beerDetailsListBoundaryCallback.errorMessage

        beerDetails = LivePagedListBuilder(
            beerDetailsDAO.getAll().map { it.toDomain() },
            PAGE_SIZE
        ).setBoundaryCallback(beerDetailsListBoundaryCallback).build()

        return Result(beerDetails, errorMessage)
    }

    override suspend fun setBeerDetails(beerDetails: BeerDetails) {
        beerDetailsDAO.update(beerDetails.toDB())
    }
}