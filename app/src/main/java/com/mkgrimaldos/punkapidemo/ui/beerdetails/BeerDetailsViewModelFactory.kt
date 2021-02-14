package com.mkgrimaldos.punkapidemo.ui.beerdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

@Suppress("UNCHECKED_CAST")
class BeerDetailsViewModelFactory(private val beerDetails: BeerDetails) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BeerDetailsViewModel(beerDetails) as T
    }
}