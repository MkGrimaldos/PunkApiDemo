package com.mkgrimaldos.punkapidemo.data.database

import androidx.room.*
import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsDB

@Dao
interface BeerDetailsDAO {
    @Insert
    fun insert(beerDetails: BeerDetailsDB)

    @Update
    fun update(beerDetails: BeerDetailsDB)

    @Delete
    fun delete(beerDetails: BeerDetailsDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(beerDetailsList: List<BeerDetailsDB>)

    @Query("DELETE FROM BeerDetails")
    fun deleteAll()

    @Query("SELECT * FROM BeerDetails")
    fun getAll(): List<BeerDetailsDB>
}