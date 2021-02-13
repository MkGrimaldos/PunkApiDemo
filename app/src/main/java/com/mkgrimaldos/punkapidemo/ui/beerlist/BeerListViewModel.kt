package com.mkgrimaldos.punkapidemo.ui.beerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

class BeerListViewModel : ViewModel() {

    private var _beerList = MutableLiveData<List<BeerDetails>>()
    val beerList: LiveData<List<BeerDetails>>
        get() = _beerList

    fun fetchData() {
//        _beerList = MutableLiveData(mutableListOf())
        _beerList.postValue(
            arrayListOf(
                BeerDetails("Turia", "La cervessa del Cap i Casal"),
                BeerDetails("Estrella Levante", "Cervecica de Murcia")
            )
        )
    }
}