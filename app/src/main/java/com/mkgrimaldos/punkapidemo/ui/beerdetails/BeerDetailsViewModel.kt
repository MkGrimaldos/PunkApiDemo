package com.mkgrimaldos.punkapidemo.ui.beerdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.usecase.SetBeerDetailsUseCase
import kotlinx.coroutines.launch

class BeerDetailsViewModel(
    beerDetails: BeerDetails,
    private val setBeerDetailsUseCase: SetBeerDetailsUseCase
) : ViewModel() {

    private var _beerDetails = MutableLiveData<BeerDetails>()
    val beerDetails: LiveData<BeerDetails>
        get() = _beerDetails

    init {
        _beerDetails.postValue(beerDetails)
    }

    fun onToggleAvailability() {
        val beerDetailsAux = beerDetails.value

        beerDetailsAux?.let {
            it.isAvailable = !it.isAvailable

            _beerDetails.postValue(it)

            viewModelScope.launch {
                setBeerDetailsUseCase(it)
            }
        }
    }
}