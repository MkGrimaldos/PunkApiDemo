package com.mkgrimaldos.punkapidemo.data.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.mkgrimaldos.punkapidemo.data.database.BeerDetailsDAO
import com.mkgrimaldos.punkapidemo.data.paging.PagingConfigParams.PAGE_SIZE
import com.mkgrimaldos.punkapidemo.data.service.PunkApiService
import com.mkgrimaldos.punkapidemo.data.service.mapping.toDB
import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeerDetailsListBoundaryCallback(
    private val service: PunkApiService,
    private val beerDetailsDAO: BeerDetailsDAO
) : PagedList.BoundaryCallback<BeerDetails>() {

    private var page = 1
    private var isRequestInProgress = false

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: BeerDetails) {
        requestAndSaveData()
    }

    private fun requestAndSaveData() {
        if (!isRequestInProgress) {
            isRequestInProgress = true

            try {
                service.getBeers(page, PAGE_SIZE).enqueue(object : Callback<List<BeerDetailsApi>> {
                    override fun onResponse(
                        call: Call<List<BeerDetailsApi>>,
                        response: Response<List<BeerDetailsApi>>
                    ) {
                        if (response.isSuccessful) {
                            val beerDetailsDBList =
                                response.body()?.map { it.toDB() } ?: emptyList()

                            GlobalScope.launch {
                                beerDetailsDAO.insertOrUpdateLiteAll(beerDetailsDBList)
                                page++
                                isRequestInProgress = false
                            }
                        } else {
                            _errorMessage.postValue(
                                response.errorBody()?.string() ?: "Network error"
                            )
                            isRequestInProgress = false
                        }
                    }

                    override fun onFailure(call: Call<List<BeerDetailsApi>>, t: Throwable) {
                        _errorMessage.postValue(t.message ?: "Network error")
                        isRequestInProgress = false
                    }

                })
            } catch (e: Exception) {
                _errorMessage.postValue(e.message ?: "Network error")
                isRequestInProgress = false
            }
        }
    }
}