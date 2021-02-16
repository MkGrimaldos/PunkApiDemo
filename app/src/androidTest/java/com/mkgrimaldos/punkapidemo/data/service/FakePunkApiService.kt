package com.mkgrimaldos.punkapidemo.data.service

import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import retrofit2.Call
import retrofit2.mock.Calls
import java.io.IOException

class FakePunkApiService : PunkApiService {

    private val model = arrayListOf<BeerDetailsApi>()

    var failureMsg: String? = null

    fun addBeerDetails(beerDetails: BeerDetailsApi) {
        model.add(beerDetails)
    }

    fun clear() {
        model.clear()
    }

    override fun getBeers(page: Int, perPage: Int): Call<List<BeerDetailsApi>> {
        failureMsg?.let {
            return Calls.failure(IOException(it))
        }

        return Calls.response(model)
    }
}