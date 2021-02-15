package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mkgrimaldos.punkapidemo.R
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

class BeerListItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.beer_list_item, parent, false)
) {

    var clContainer: ConstraintLayout = itemView.findViewById(R.id.cl_container)
    var ivBeerIcon: ImageView = itemView.findViewById(R.id.iv_beer_icon)
    var tvName: TextView = itemView.findViewById(R.id.tv_name)
    var tvTagline: TextView = itemView.findViewById(R.id.tv_tagline)

    fun bind(beerDetails: BeerDetails) {
        val bgColour = ContextCompat.getColor(
            clContainer.context,
            if (beerDetails.isAvailable) android.R.color.white else android.R.color.darker_gray
        )

        clContainer.setBackgroundColor(bgColour)

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
