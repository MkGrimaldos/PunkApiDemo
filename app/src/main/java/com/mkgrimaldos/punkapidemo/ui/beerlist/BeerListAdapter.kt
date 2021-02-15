package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails


class BeerListAdapter :
    PagedListAdapter<BeerDetails, BeerListItemViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<BeerDetails>() {
            override fun areItemsTheSame(oldItem: BeerDetails, newItem: BeerDetails): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: BeerDetails, newItem: BeerDetails): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListItemViewHolder =
        BeerListItemViewHolder(parent)

    override fun onBindViewHolder(holder: BeerListItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}