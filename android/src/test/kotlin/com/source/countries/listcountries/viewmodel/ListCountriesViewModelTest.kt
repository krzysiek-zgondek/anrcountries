package com.source.countries.listcountries.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.source.countries.common.Resource
import com.source.countries.common.TestMainCoroutineRule
import com.source.countries.common.mock
import com.source.countries.common.observeTesting
import com.source.countries.listcountries.interaction.GetAllCountries
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.model.Currency
import com.source.countries.listcountries.model.fromModelList
import com.source.countries.listcountries.model.toModelList
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class ListCountriesViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainRule = TestMainCoroutineRule()

    private val countries = listOf(
        Country("1", listOf("1"), listOf("1"), listOf(Currency("1", "1", "1"))),
        Country("2", listOf("2"), listOf("2"), listOf(Currency("2", "2", "2")))
    )

    @Test
    fun `should enter error state if error occurs`() {
        val getAllCountries: GetAllCountries = mock()
        val reason = Throwable("my error")
        Mockito.`when`(getAllCountries.invoke()).thenReturn(
            flow { emit(Resource.error(reason)) }
        )

        val viewModel = ListCountriesViewModel(getAllCountries, mainRule.dispatcher)
        mainRule.dispatcher.runBlockingTest {
            val loading = viewModel.getCountries().observeTesting()
            Assert.assertTrue(loading.isLoading)

            val state = viewModel.getCountries().observeTesting()
            Assert.assertFalse(state.isLoading)
            Assert.assertTrue(state.countries.isEmpty())
            Assert.assertTrue(state.isErrorShow)
            Assert.assertTrue(state.error == reason)
        }
    }

    @Test
    fun `should enter list presentation state if load occurs`() {
        val getAllCountries: GetAllCountries = mock()
        Mockito.`when`(getAllCountries.invoke()).thenReturn(
            flow { emit(Resource.success(countries)) }
        )

        val viewModel = ListCountriesViewModel(getAllCountries, mainRule.dispatcher)
        mainRule.dispatcher.runBlockingTest {
            val loading = viewModel.getCountries().observeTesting()
            Assert.assertTrue(loading.isLoading)

            val state = viewModel.getCountries().observeTesting()
            Assert.assertFalse(state.isLoading)
            Assert.assertEquals(countries, state.countries.toModelList().fromModelList())
            Assert.assertFalse(state.isErrorShow)
            Assert.assertNull(state.error)
        }
    }
}