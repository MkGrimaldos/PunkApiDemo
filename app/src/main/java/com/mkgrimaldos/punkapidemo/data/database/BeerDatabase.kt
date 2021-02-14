package com.mkgrimaldos.punkapidemo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mkgrimaldos.punkapidemo.data.database.mapping.Converters
import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsDB

@Database(entities = [BeerDetailsDB::class], version = 1)
@TypeConverters(Converters::class)
abstract class BeerDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDetailsDAO
}