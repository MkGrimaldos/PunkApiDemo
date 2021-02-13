package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkgrimaldos.punkapidemo.R
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails


class BeerListAdapter(var beerList: List<BeerDetails> = emptyList()) :
    RecyclerView.Adapter<BeerListItemViewHolder>() {

//    private val _contractLiveData = MutableLiveData<Event<ContractToSign>>()
//    fun getContractLiveData(): LiveData<Event<ContractToSign>> = _contractLiveData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.beer_list_item, parent, false)
        return BeerListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeerListItemViewHolder, position: Int) {
//        val context = holder.tvName.context

        holder.bind(beerList[position])

//        holder.tvName.text = beerList[position].name
//        holder.tvTagline.text = beerList[position].tagline
//        if (beerList[position].status == ContractToSign.ContractStatus.PENDING) {
//            holder.tvStatus.text =
//                context.getString(R.string.contract_review_pending)
//            holder.tvStatus.setTextColor(
//                ContextCompat.getColor(
//                    context,
//                    android.R.color.holo_red_light
//                )
//            )
//        } else {
//            holder.tvStatus.text =
//                context.getString(R.string.contract_review_signed)
//            holder.tvStatus.setTextColor(
//                ContextCompat.getColor(
//                    context,
//                    android.R.color.holo_orange_dark
//                )
//            )
//        }

        holder.itemView.setOnClickListener {
//            _contractLiveData.postValue(Event(beerList[position]))
        }
    }

    override fun getItemCount(): Int {
        return beerList.size
    }
}