package com.source.countries.listcountries.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class CurrencyItem(
    @Id var id: Long,
    val code: String,
    val name: String,
    val symbol: String
)

@Suppress("NOTHING_TO_INLINE")
inline fun Currency.toItem(): CurrencyItem {
    return CurrencyItem(
        id = 0L,
        code = code ?: "",
        name = name ?: "",
        symbol = symbol ?: ""
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<Currency>.toItemList(): List<CurrencyItem> {
    return map(Currency::toItem)
}

@Suppress("NOTHING_TO_INLINE")
inline fun CurrencyItem.toModel(): CurrencyModel {
    return CurrencyModel(
        code = code,
        name = name,
        symbol = symbol
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<CurrencyItem>.toModelList(): List<CurrencyModel> {
    return map(CurrencyItem::toModel)
}
