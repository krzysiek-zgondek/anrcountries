package com.source.countries.listcountries.model

import com.source.countries.model.model.Country


data class CountryItem(
    val name: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val currencies: List<CurrencyItem> = emptyList()
)


@Suppress("NOTHING_TO_INLINE")
inline fun Country.toItem(): CountryItem {
    return CountryItem(
        name = name ?: "",
        topLevelDomain = topLevelDomain ?: emptyList(),
        callingCodes = callingCodes ?: emptyList(),
        currencies = currencies?.toItemList() ?: emptyList()
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Country>.toItemList(): List<CountryItem> {
    return map(Country::toItem)
}