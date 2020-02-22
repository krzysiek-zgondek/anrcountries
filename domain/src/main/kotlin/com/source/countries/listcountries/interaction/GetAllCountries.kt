package com.source.countries.listcountries.interaction

import com.source.countries.common.Resource
import com.source.countries.listcountries.model.Country
import kotlinx.coroutines.flow.Flow


interface GetAllCountries : () -> Flow<Resource<List<Country>>>
