package com.source.countries.listcountries.model

import com.source.countries.model.model.Currency


data class CurrencyItem(
    val code: String,
    val name: String,
    val symbol: String
)

@Suppress("NOTHING_TO_INLINE")
inline fun Currency.toItem(): CurrencyItem {
    return CurrencyItem(
        code = code ?: "",
        name = name ?: "",
        symbol = symbol ?: ""
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Currency>.toItemList(): List<CurrencyItem> {
    return map(Currency::toItem)
}
