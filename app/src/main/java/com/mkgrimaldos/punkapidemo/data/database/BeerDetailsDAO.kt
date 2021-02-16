package com.mkgrimaldos.punkapidemo.data.database

import androidx.paging.DataSource
import androidx.room.*
import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsDB
import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsLiteDB

@Dao
abstract class BeerDetailsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(beerDetails: BeerDetailsDB): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertAll(beerDetailsList: List<BeerDetailsDB>): List<Long>

    @Update
    abstract suspend fun update(beerDetails: BeerDetailsDB)

    @Update
    abstract fun updateAll(beerDetailsList: List<BeerDetailsDB>)

    @Update(entity = BeerDetailsDB::class)
    abstract fun updateLite(beerDetails: BeerDetailsLiteDB)

    @Update(entity = BeerDetailsDB::class)
    abstract fun updateLiteAll(beerDetailsList: List<BeerDetailsLiteDB>)

    @Delete
    abstract fun delete(beerDetails: BeerDetailsDB)

    @Query("DELETE FROM BeerDetails")
    abstract fun deleteAll()

    @Query("SELECT * FROM BeerDetails")
    abstract fun getAll(): DataSource.Factory<Int, BeerDetailsDB>

    @Query("SELECT * FROM BeerDetails WHERE id = :id")
    abstract fun getBeerDetails(id: Int): BeerDetailsDB?

    @Transaction
    open fun insertOrUpdateLite(beerDetails: BeerDetailsDB) {
        val id = insert(beerDetails)

        if (id == -1L) {
            updateLite(BeerDetailsLiteDB(beerDetails))
        }
    }

    @Transaction
    open fun insertOrUpdateLiteAll(beerDetailsList: List<BeerDetailsDB>) {
        val insertedIds = insertAll(beerDetailsList)
        val updateList = mutableListOf<BeerDetailsLiteDB>()

        for (i in insertedIds.indices) {
            if (insertedIds[i] == -1L) {
                updateList.add(BeerDetailsLiteDB(beerDetailsList[i]))
            }
        }

        if (updateList.isNotEmpty()) {
            updateLiteAll(updateList)
        }
    }
}