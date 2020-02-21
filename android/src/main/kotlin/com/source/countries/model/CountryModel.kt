package com.source.countries.model


data class CountryModel(
    val name: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val currencies: List<CurrencyModel> = emptyList()
)


@Suppress("NOTHING_TO_INLINE")
inline fun Country.toModel(): CountryModel {
    val mappedCurrencies = currencies.map(Currency::toModel)

    return CountryModel(
        name = name,
        topLevelDomain = topLevelDomain,
        callingCodes = callingCodes,
        currencies = mappedCurrencies
    )
}