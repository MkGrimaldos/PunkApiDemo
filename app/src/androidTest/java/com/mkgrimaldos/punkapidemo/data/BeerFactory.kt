package com.mkgrimaldos.punkapidemo.data

import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsDB
import com.mkgrimaldos.punkapidemo.data.service.model.BeerDetailsApi
import java.util.concurrent.atomic.AtomicInteger

class BeerFactory {
    private val counter = AtomicInteger(0)
    fun createBeerDetailsDB(): BeerDetailsDB {
        val id = counter.incrementAndGet()
        return BeerDetailsDB(
            id,
            "name_$id",
            "tagline $id",
            "url_$id",
            "description $id",
            "abv $id",
            "ibu $id",
            arrayListOf(
                "food pairing $id",
                "food pairing $id",
                "food pairing $id"
            ),
            id % 2 == 0
        )
    }

    fun createBeerDetailsApi(): BeerDetailsApi {
        val id = counter.incrementAndGet()
        return BeerDetailsApi(
            id,
            "name_$id",
            "tagline $id",
            "first brewed $id",
            "description $id",
            "url_$id",
            id.toFloat(),
            id.toFloat(),
            id.toFloat(),
            id.toFloat(),
            id.toFloat(),
            id.toFloat(),
            id.toFloat(),
            id.toFloat(),
            arrayListOf(
                "food pairing $id",
                "food pairing $id",
                "food pairing $id"
            ),
            "Tip $id",
            "Contribute by $id",
        )
    }
}