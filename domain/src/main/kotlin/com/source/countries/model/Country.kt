package com.source.countries.model

/**
 * @project Countries
 * @author SourceOne on 21.02.2020
 */

data class Country(
    val name: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val currencies: List<Currency>
)

