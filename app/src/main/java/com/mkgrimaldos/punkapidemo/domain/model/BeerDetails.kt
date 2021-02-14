package com.mkgrimaldos.punkapidemo.domain.model

data class BeerDetails(
    val id: Int,
    val name: String,
    val tagline: String,
    val imageUrl: String,
    val description: String,
    val alcoholByVolume: Float,
    val bitterness: Float,
    val foodPairing: List<String>
)