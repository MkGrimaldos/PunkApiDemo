package com.mkgrimaldos.punkapidemo.data.database

import com.mkgrimaldos.punkapidemo.data.database.mapping.Converters
import junit.framework.Assert.assertEquals
import org.junit.Test

class ConvertersUnitTest {

    private val sampleList = arrayListOf("food pairing id", "food pairing id", "food pairing id")
    private val sampleJson = "[\"food pairing id\",\"food pairing id\",\"food pairing id\"]"

    @Test
    fun listToJson() {
        assertEquals(Converters().listToJson(sampleList), sampleJson)
    }

    @Test
    fun jsonToList() {
        assertEquals(Converters().jsonToList(sampleJson), sampleList)
    }
}