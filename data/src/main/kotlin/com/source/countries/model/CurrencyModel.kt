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
inline fun CurrencyModel.fromModel(): Currency {
    return Currency(
        code = code,
        name = name,
        symbol = symbol
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Currency>.toModelList(): List<CurrencyModel> {
    return map(Currency::toModel)
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<CurrencyModel>.fromModelList(): List<Currency> {
    return map(CurrencyModel::fromModel)
}