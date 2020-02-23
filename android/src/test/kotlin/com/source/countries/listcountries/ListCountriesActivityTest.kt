package com.source.countries.listcountries

import android.os.Looper.getMainLooper
import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.launchActivity
import com.source.countries.R
import com.source.countries.allModules
import com.source.countries.common.mock
import com.source.countries.listcountries.model.Country
import com.source.countries.listcountries.model.Currency
import com.source.countries.listcountries.viewmodel.ListCountriesState
import com.source.countries.listcountries.viewmodel.ListCountriesViewModel
import org.junit.*
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

/*
* Note. On windows when running Robolectric tests sometimes you need to run "gradlew test" manually
* for the first time. That is a bug either in current android studio or Robolectric itself
* */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
@LooperMode(LooperMode.Mode.PAUSED)
class ListCountriesActivityTest : KoinTest {
    private val countries = listOf(
        Country("1", listOf("1"), listOf("1"), listOf(Currency("1", "1", "1"))),
        Country("2", listOf("2"), listOf("2"), listOf(Currency("2", "2", "2")))
    )

    @get:Rule
    val instantRuntime = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    lateinit var mockedViewModel: ListCountriesViewModel

    @Before
    fun setup() {
        mockedViewModel = mock()

        unloadKoinModules(allModules)
        loadKoinModules(module {
            viewModel { mockedViewModel }
        })
    }

    @After
    fun tearDown(){
        stopKoin()
    }

    @Test
    fun `loading state should display loading view`() {
        Mockito.`when`(mockedViewModel.getCountries()).thenReturn(
            MutableLiveData<ListCountriesState>(ListCountriesState.loading())
        )

        val scenario = launchActivity<ListCountriesActivity>()
        scenario.moveToState(Lifecycle.State.STARTED)

        scenario.onActivity { activity ->
            val shadow = shadowOf(activity).contentView
            val loadingView = shadow.findViewById<View>(R.id.loadingView)
            val errorView = shadow.findViewById<View>(R.id.errorView)

            Assert.assertTrue(loadingView.visibility == View.VISIBLE)
            Assert.assertTrue(errorView.visibility == View.GONE)
        }
    }


    @Test
    fun `error state should display error and log it to console`() {
        Mockito.`when`(mockedViewModel.getCountries()).thenReturn(
            MutableLiveData<ListCountriesState>(ListCountriesState.error(Throwable()))
        )

        val scenario = launchActivity<ListCountriesActivity>()
        scenario.moveToState(Lifecycle.State.STARTED)

        scenario.onActivity { activity ->
            shadowOf(getMainLooper()).idle()

            val shadow = shadowOf(activity).contentView
            val loadingView = shadow.findViewById<View>(R.id.loadingView)
            val errorView = shadow.findViewById<View>(R.id.errorView)

            Assert.assertTrue(loadingView.visibility == View.GONE)
            Assert.assertTrue(errorView.visibility == View.VISIBLE)
        }
    }

    @Test
    fun `data state should display list`() {
        Mockito.`when`(mockedViewModel.getCountries()).thenReturn(
            MutableLiveData<ListCountriesState>(ListCountriesState.loaded(countries))
        )

        val scenario = launchActivity<ListCountriesActivity>()
        scenario.moveToState(Lifecycle.State.STARTED)

        scenario.onActivity { activity ->
            val shadow = shadowOf(activity).contentView
            val loadingView = shadow.findViewById<View>(R.id.loadingView)
            val errorView = shadow.findViewById<View>(R.id.errorView)
            val listView = shadow.findViewById<RecyclerView>(R.id.countryListView)

            Assert.assertTrue(loadingView.visibility == View.GONE)
            Assert.assertTrue(errorView.visibility == View.GONE)
            Assert.assertEquals(countries.size, listView.adapter?.itemCount)
        }
    }
}