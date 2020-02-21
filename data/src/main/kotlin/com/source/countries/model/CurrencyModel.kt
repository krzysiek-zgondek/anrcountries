package com.source.countries.model

import com.source.countries.model.model.Currency


data class CurrencyModel(
    val code: String,
    val name: String,
    val symbol: String
)


@Suppress("NOTHING_TO_INLINE")
inline fun Currency.toModel(): CurrencyModel {
    return CurrencyModel(
        code = code ?: "",
        name = name ?: "",
        symbol = symbol ?: ""
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Currency>.toModelList(): List<CurrencyModel> {
    return map(Currency::toModel)
}