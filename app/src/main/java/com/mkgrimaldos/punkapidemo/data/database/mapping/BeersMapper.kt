package com.mkgrimaldos.punkapidemo.data.database.mapping

import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsDB
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

fun BeerDetailsDB.toDomain(): BeerDetails {
    return BeerDetails(
        id,
        name,
        tagline,
        imageUrl,
        description,
        alcoholByVolume,
        bitterness,
        foodPairing
    )
}