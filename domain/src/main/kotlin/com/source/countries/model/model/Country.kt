package com.source.countries.model.model

data class Country(
    val name: String?,
    val topLevelDomain: List<String>?,
    val callingCodes: List<String>?,
    val currencies: List<Currency>?
)