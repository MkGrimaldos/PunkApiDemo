package com.mkgrimaldos.punkapidemo.data.service.model

import com.google.gson.annotations.SerializedName

data class BeerDetailsApi(
    val id: String,
    val name: String,
    val tagline: String,
    @SerializedName("image_url") val imageUrl: String
)