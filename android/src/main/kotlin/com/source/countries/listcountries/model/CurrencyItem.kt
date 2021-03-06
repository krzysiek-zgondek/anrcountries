package com.source.countries.listcountries.model

data class CurrencyItem(
    var id: Long = 0L,
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
