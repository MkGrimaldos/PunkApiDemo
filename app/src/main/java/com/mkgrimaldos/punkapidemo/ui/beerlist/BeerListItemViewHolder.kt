package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mkgrimaldos.punkapidemo.R
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

class BeerListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var ivBeerIcon: ImageView = itemView.findViewById(R.id.iv_beer_icon)
    var tvName: TextView = itemView.findViewById(R.id.tv_name)
    var tvTagline: TextView = itemView.findViewById(R.id.tv_tagline)

    fun bind(beerDetails: BeerDetails) {
        Glide.with(ivBeerIcon)
            .load(beerDetails.imageUrl)
            .centerInside()
            .placeholder(null)
            .into(ivBeerIcon)

        tvName.text = beerDetails.name
        tvTagline.text = beerDetails.tagline

        itemView.setOnClickListener {
            val direction =
                BeerListFragmentDirections.actionBeerListFragmentToBeerDetailsFragment(beerDetails)
            itemView.findNavController().navigate(direction)
        }
    }
}
