package com.mkgrimaldos.punkapidemo.data.database

import androidx.room.paging.LimitOffsetDataSource
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mkgrimaldos.punkapidemo.data.BeerFactory
import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsDB
import com.mkgrimaldos.punkapidemo.data.database.model.BeerDetailsLiteDB
import com.mkgrimaldos.punkapidemo.testModule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class BeerDetailsDAOTest : KoinTest {

    private val beerDatabase by inject<BeerDatabase>()
    private val beerDetailsDao by inject<BeerDetailsDAO>()

    private val beerDetailDBList =
        mutableListOf(
            BeerFactory().createBeerDetailsDB(),
            BeerFactory().createBeerDetailsDB(),
            BeerFactory().createBeerDetailsDB()
        )

    @Before
    fun setUpDatabase() {
        stopKoin()
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(testModule)
        }
    }

    @After
    fun closeDB() {
        beerDatabase.close()
        stopKoin()
    }

    @Test
    fun insertBeerDetails_SavesData() {
        val beerDetailsDBAux = BeerFactory().createBeerDetailsDB()

        beerDetailsDao.insert(beerDetailsDBAux)

        val queryResponse = (beerDetailsDao.getAll()
            .create() as LimitOffsetDataSource<BeerDetailsDAO>).loadRange(0, 1)
        assert(queryResponse.isNotEmpty())
    }

    @Test
    fun insertBeerDetailsList_SavesData() {
        beerDetailsDao.insertAll(beerDetailDBList)

        val queryResponse = (beerDetailsDao.getAll()
            .create() as LimitOffsetDataSource<BeerDetailsDAO>).loadRange(0, 1)
        assert(queryResponse.isNotEmpty())
    }

    @Test
    fun updateBeerDetailsList_UpdatesData() {
        val beerDetailsDBAux = BeerDetailsDB(
            beerDetailDBList[0].id,
            beerDetailDBList[0].name,
            beerDetailDBList[0].tagline,
            beerDetailDBList[0].imageUrl,
            beerDetailDBList[0].description,
            beerDetailDBList[0].alcoholByVolume,
            beerDetailDBList[0].bitterness,
            beerDetailDBList[0].foodPairing,
            false
        )

        beerDetailsDao.insertAll(beerDetailDBList)

        val beerList = mutableListOf<BeerDetailsDB>()
        beerList.add(beerDetailsDBAux)
        beerList.add(beerDetailDBList[1])

        beerDetailsDao.updateAll(beerList)

        val queryResponse = beerDetailsDao.getBeerDetails(beerDetailsDBAux.id)
        assert(queryResponse?.isAvailable == false)
    }

    @Test
    fun updateBeerDetailsLite_UpdatesData() {
        val beerDetailsDBAux = BeerDetailsLiteDB(
            beerDetailDBList[1].id,
            beerDetailDBList[1].name,
            beerDetailDBList[1].tagline,
            beerDetailDBList[1].imageUrl,
            beerDetailDBList[1].description,
            beerDetailDBList[1].alcoholByVolume,
            beerDetailDBList[1].bitterness,
            beerDetailDBList[1].foodPairing
        )

        beerDetailsDao.insertAll(beerDetailDBList)

        beerDetailsDao.updateLite(beerDetailsDBAux)

        val queryResponse = beerDetailsDao.getBeerDetails(beerDetailsDBAux.id)
        assert(queryResponse?.isAvailable == beerDetailDBList[1].isAvailable)
    }

    @Test
    fun updateBeerDetailsLiteList_UpdatesData() {
        val beerDetailsDBAux = BeerDetailsLiteDB(
            beerDetailDBList[1].id,
            beerDetailDBList[1].name,
            beerDetailDBList[1].tagline,
            beerDetailDBList[1].imageUrl,
            beerDetailDBList[1].description,
            beerDetailDBList[1].alcoholByVolume,
            beerDetailDBList[1].bitterness,
            beerDetailDBList[1].foodPairing
        )

        beerDetailsDao.insertAll(beerDetailDBList)

        val beerList = mutableListOf<BeerDetailsLiteDB>()
        beerList.add(beerDetailsDBAux)

        beerDetailsDao.updateLiteAll(beerList)

        val queryResponse = beerDetailsDao.getBeerDetails(beerDetailsDBAux.id)
        assert(queryResponse?.isAvailable == beerDetailDBList[1].isAvailable)
    }

    @Test
    fun deleteBeerDetails_ClearsData() {
        val beerDetailsDBAux = beerDetailDBList[0]
        beerDetailsDao.insertAll(beerDetailDBList)

        beerDetailsDao.delete(beerDetailsDBAux)

        val queryResponse = beerDetailsDao.getBeerDetails(beerDetailsDBAux.id)
        assert(queryResponse == null)
    }

    @Test
    fun deleteBeerDetailsList_ClearsData() {
        beerDetailsDao.insertAll(beerDetailDBList)

        beerDetailsDao.deleteAll()

        val queryResponse = (beerDetailsDao.getAll()
            .create() as LimitOffsetDataSource<BeerDetailsDAO>).loadRange(0, 1)
        assert(queryResponse.isEmpty())
    }
}