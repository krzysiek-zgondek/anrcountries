package com.source.countries.common

import org.mockito.Mockito


inline fun <reified T> mock(): T = Mockito.mock(T::class.java)