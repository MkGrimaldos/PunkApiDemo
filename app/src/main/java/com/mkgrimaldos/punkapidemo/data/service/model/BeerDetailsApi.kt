package com.mkgrimaldos.punkapidemo.data.service.model

import com.google.gson.annotations.SerializedName

data class BeerDetailsApi(
    val id: Int,
    val name: String?,
    val tagline: String?,
    @SerializedName("first_brewed") val firstBrewed: String?,
    val description: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("abv") val alcoholByVolume: Float?,
    @SerializedName("ibu") val bitterness: Float?,
    @SerializedName("target_fg") val targetFg: Float?,
    @SerializedName("target_og") val targetOg: Float?,
    val ebc: Float?,
    val srm: Float?,
    val ph: Float?,
    @SerializedName("attenuation_level") val attenuationLevel: Float?,
    @SerializedName("food_pairing") val foodPairing: List<String>?,
    @SerializedName("brewers_tips") val brewersTips: String?,
    @SerializedName("contributed_by") val contributedBy: String?
)