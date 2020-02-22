package com.source.countries.listcountries.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import org.threeten.bp.OffsetDateTime


@Entity
data class CountryItem(
    @Id val id: Long,
    val name: String,
    val createdAt:  OffsetDateTime,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val currencies: List<CurrencyItem> = emptyList()
)


@Suppress("NOTHING_TO_INLINE")
inline fun Country.toItem(): CountryItem {
    return CountryItem(
        id = 0L,
        name = name ?: "",
        createdAt = OffsetDateTime.now(),
        topLevelDomain = topLevelDomain ?: emptyList(),
        callingCodes = callingCodes ?: emptyList(),
        currencies = currencies?.toItemList() ?: emptyList()
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Country>.toItemList(): List<CountryItem> {
    return map(Country::toItem)
}