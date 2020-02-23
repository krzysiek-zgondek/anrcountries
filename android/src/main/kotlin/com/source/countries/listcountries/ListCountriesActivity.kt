package com.source.countries.listcountries

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.source.countries.R
import com.source.countries.listcountries.adapter.ListCountryAdapter
import com.source.countries.listcountries.viewmodel.ListCountriesState
import com.source.countries.listcountries.viewmodel.ListCountriesViewModel
import kotlinx.android.synthetic.main.activity_list_countries.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListCountriesActivity : AppCompatActivity() {
    private val countryViewModel: ListCountriesViewModel by viewModel()
    private val countryAdapter = ListCountryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_countries)

        bindViews()
    }

    override fun onStart() {
        super.onStart()
        requestCountries()
    }

    private fun bindViews() {
        errorView.setOnClickListener { requestCountries() }

        swipeRefreshView.setOnRefreshListener {
            swipeRefreshView.isRefreshing = false
            requestCountries(fresh = true)
        }

        countryListView.adapter = countryAdapter
    }

    private fun requestCountries(fresh: Boolean = false) {
        countryViewModel.getCountries(fresh).observe(this, ::updateState)
    }

    internal fun updateState(state: ListCountriesState) {
        countryAdapter.items = state.countries

        showLoading(state.isLoading)
        showError(state.isErrorShow, state.error)
    }

    private fun showError(isVisible: Boolean, reason: Throwable? = null) {
        reason?.printStackTrace() //log somewhere
        errorView.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun showLoading(isVisible: Boolean) {
        loadingView.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}