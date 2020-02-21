package com.source.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_list_countries.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCountriesActivity : AppCompatActivity() {
    private val countryViewModel by viewModel<ListCountriesViewModel>()

    private val countryAdapter = ListCountryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_countries)

        countryListView.adapter = countryAdapter

        countryViewModel.getCountries().observe(this) { countries ->
            countryAdapter.items = countries
        }
    }
}