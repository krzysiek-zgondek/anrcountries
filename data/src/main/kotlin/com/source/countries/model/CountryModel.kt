package com.source.countries.model

import com.source.countries.model.model.Country


data class CountryModel(
    val name: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val currencies: List<CurrencyModel> = emptyList()
)


@Suppress("NOTHING_TO_INLINE")
inline fun Country.toModel(): CountryModel {
    return CountryModel(
        name = name ?: "",
        topLevelDomain = topLevelDomain ?: emptyList(),
        callingCodes = callingCodes ?: emptyList(),
        currencies = currencies?.toModelList() ?: emptyList()
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Country>.toModelList(): List<CountryModel> {
    return map(Country::toModel)
}