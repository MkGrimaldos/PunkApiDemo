package com.mkgrimaldos.punkapidemo.data.service.mapping

import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails

fun BeerDetailsApi.toDomain(): BeerDetails {
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