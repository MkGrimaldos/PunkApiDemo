package com.mkgrimaldos.punkapidemo.ui.beerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.usecase.GetBeerListUseCase
import kotlinx.coroutines.launch

class BeerListViewModel(private val getBeerListUseCase: GetBeerListUseCase) : ViewModel() {

    lateinit var error: LiveData<String>
    lateinit var beerList: LiveData<PagedList<BeerDetails>>

    init {
        viewModelScope.launch {
            processResult(getBeerListUseCase())
        }
    }

    private fun processResult(result: Result<BeerDetails>) {
        beerList = result.data
        error = result.error
    }
}