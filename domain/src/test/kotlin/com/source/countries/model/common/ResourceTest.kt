package com.source.countries.model.common

import org.junit.Assert.assertEquals
import org.junit.Test


class ResourceTest {

    @Test
    fun `resource captures all exceptions`() {
        val reason = Throwable()
        val resource = resource<Any> {
            throw reason
        }

        resource as Resource.Error
        assertEquals(reason, resource.reason)
    }

    @Test
    fun `resource captures any values`() {
        val result = Any()
        val resource = resource {
            result
        }

        resource as Resource.Success
        assertEquals(result, resource.value)
    }

}