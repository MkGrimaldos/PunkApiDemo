package com.mkgrimaldos.punkapidemo.data.repository

import androidx.paging.PagedList
import androidx.test.core.app.ApplicationProvider
import com.mkgrimaldos.punkapidemo.domain.model.BeerDetails
import com.mkgrimaldos.punkapidemo.domain.repository.BeerRepository
import com.mkgrimaldos.punkapidemo.testModule
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.internal.InOrderImpl
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BeerRepositoryImplTest : KoinTest {

    private val beerRepository by inject<BeerRepository>()

    @Before
    fun init() {
        stopKoin()
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(testModule)
        }
    }

    @After
    fun end() {
        stopKoin()
    }

    @Test
    fun getBeerList_success() = runBlocking {
        val result = beerRepository.getBeerList()
        assertTrue(result.data.value is PagedList<BeerDetails>)
    }
}