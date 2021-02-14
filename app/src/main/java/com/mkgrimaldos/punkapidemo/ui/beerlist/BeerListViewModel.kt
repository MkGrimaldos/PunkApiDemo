package com.mkgrimaldos.punkapidemo.ui.beerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkgrimaldos.punkapidemo.domain.Result
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.usecase.GetBeerListUseCase
import kotlinx.coroutines.launch

class BeerListViewModel(private val getBeerListUseCase: GetBeerListUseCase) : ViewModel() {

    private var _beerList = MutableLiveData<List<BeerDetails>>()
    val beerList: LiveData<List<BeerDetails>>
        get() = _beerList

    init {
        viewModelScope.launch {
            // TODO: Show loading view
            processResult(getBeerListUseCase())
        }
    }

    private fun processResult(result: Result<List<BeerDetails>>) {
        when (result) {
            is Result.Success -> {
                _beerList.postValue(result.data)
            }
            is Result.Error -> {

            }
        }
    }
}