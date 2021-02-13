package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mkgrimaldos.punkapidemo.R
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

class BeerListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvName: TextView = itemView.findViewById(R.id.tv_name)
    var tvTagline: TextView = itemView.findViewById(R.id.tv_tagline)

    fun bind(beerDetails: BeerDetails) {
        tvName.text = beerDetails.name
        tvTagline.text = beerDetails.tagline
    }
}
