package com.mkgrimaldos.punkapidemo.data.database.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class BeerDetailsLiteDB(
    @PrimaryKey val id: Int,
    val name: String,
    val tagline: String,
    val imageUrl: String,
    val description: String,
    @ColumnInfo(name = "abv") val alcoholByVolume: String,
    @ColumnInfo(name = "ibu") val bitterness: String,
    val foodPairing: List<String>,
) {
    constructor(beerDetailsDB: BeerDetailsDB) : this(
        beerDetailsDB.id,
        beerDetailsDB.name,
        beerDetailsDB.tagline,
        beerDetailsDB.imageUrl,
        beerDetailsDB.description,
        beerDetailsDB.alcoholByVolume,
        beerDetailsDB.bitterness,
        beerDetailsDB.foodPairing
    )
}