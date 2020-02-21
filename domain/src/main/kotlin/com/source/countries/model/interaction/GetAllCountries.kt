package com.source.countries.model.interaction

import com.source.countries.model.common.Resource
import com.source.countries.model.model.Country
import kotlinx.coroutines.flow.Flow


interface GetAllCountries : () -> Flow<Resource<List<Country>>>
