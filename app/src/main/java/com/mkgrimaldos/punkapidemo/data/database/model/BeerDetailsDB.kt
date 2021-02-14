package com.mkgrimaldos.punkapidemo.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BeerDetails")
data class BeerDetailsDB(
    @PrimaryKey val id: Int,
    val name: String,
    val tagline: String,
    val imageUrl: String,
    val description: String,
    @ColumnInfo(name = "abv") val alcoholByVolume: String,
    @ColumnInfo(name = "ibu") val bitterness: String,
    val foodPairing: List<String>,
    val isAvailable: Boolean
)