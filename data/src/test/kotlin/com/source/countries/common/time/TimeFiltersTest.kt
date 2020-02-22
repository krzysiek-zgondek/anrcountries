package com.source.countries.common.time

import org.junit.Assert.assertEquals
import org.junit.Test
import org.threeten.bp.Duration
import org.threeten.bp.LocalDateTime

class TimeFiltersTest {

    @Test
    fun `filterOutdated correctly removes outdated items`() {
        val now = LocalDateTime.now()
        val list = listOf(
            now - Duration.ofSeconds(15),
            now - Duration.ofSeconds(15),
            now - Duration.ofSeconds(15),
            now + Duration.ofSeconds(15)
        )

        val result =
            list.filterOutdated(Duration.ofSeconds(10)) { it }

        assertEquals(1, result.size)
    }
}