package com.mkgrimaldos.punkapidemo.domain.model

data class BeerDetails(
    val id: Int,
    val name: String,
    val tagline: String,
    val imageUrl: String,
    val description: String,
    val alcoholByVolume: String,
    val bitterness: String,
    val foodPairing: List<String>
) {
    fun getFormattedFoodPairing(): String {
        var resultString = ""

        for (pairing in foodPairing) {
            resultString += "- $pairing\n\n"
        }

        return resultString
    }
}