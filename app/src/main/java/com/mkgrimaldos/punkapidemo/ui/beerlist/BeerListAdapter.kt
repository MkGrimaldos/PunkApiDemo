package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkgrimaldos.punkapidemo.R
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails


class BeerListAdapter(var beerList: List<BeerDetails> = emptyList()) :
    RecyclerView.Adapter<BeerListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.beer_list_item, parent, false)
        return BeerListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeerListItemViewHolder, position: Int) {
        holder.bind(beerList[position])
    }

    override fun getItemCount(): Int {
        return beerList.size
    }
}