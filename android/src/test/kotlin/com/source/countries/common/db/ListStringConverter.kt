package com.source.countries.common.db

import org.junit.Assert
import org.junit.Test


class ListStringConverterTest{
    private val list = listOf("abc", "cde", "efg")

    @Test
    fun `converts values properly`(){
        val converter = ListStringConverter()

        val converted = converter.convertToDatabaseValue(list)
        val decoded = converter.convertToEntityProperty(converted)

        Assert.assertEquals(list, decoded)
    }
}