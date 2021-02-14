package com.mkgrimaldos.punkapidemo.ui.beerdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

class BeerDetailsViewModel(beerDetails: BeerDetails) : ViewModel() {

    private var _beerDetails = MutableLiveData<BeerDetails>()
    val beerDetails: LiveData<BeerDetails>
        get() = _beerDetails

    init {
        _beerDetails.postValue(beerDetails)
    }
}