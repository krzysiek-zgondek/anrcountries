package com.source.countries.common.db

import org.junit.Assert
import org.junit.Test
import org.threeten.bp.OffsetDateTime


class OffsetDateTimeConverterTest {
    @Test
    fun `converts values properly`() {
        val converter = OffsetDateTimeConverter()

        run {
            val expected = OffsetDateTime.MIN
            val decoded =
                converter.convertToEntityProperty(converter.convertToDatabaseValue(expected))
            Assert.assertEquals(expected, decoded)
        }

        run {
            val expected = OffsetDateTime.now()
            val decoded =
                converter.convertToEntityProperty(converter.convertToDatabaseValue(expected))
            Assert.assertEquals(expected, decoded)
        }

        run {
            val expected = OffsetDateTime.MAX
            val decoded =
                converter.convertToEntityProperty(converter.convertToDatabaseValue(expected))
            Assert.assertEquals(expected, decoded)
        }
    }
}