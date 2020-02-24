package com.source.countries.listcountries.db

import androidx.room.TypeConverter
import com.source.countries.common.moshi.createMoshi
import com.source.countries.listcountries.model.CurrencyItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types
import java.lang.reflect.Type


private var currencyList: Type = Types.newParameterizedType(
    MutableList::class.java,
    CurrencyItem::class.java
)

private val adapter: JsonAdapter<List<CurrencyItem>> =
    createMoshi().adapter(currencyList)

class ListCurrencyConverter {
    @TypeConverter
    fun convertToDatabaseValue(entityProperty: List<CurrencyItem>?): String? {
        return adapter.toJson(entityProperty)
    }

    @TypeConverter
    fun convertToEntityProperty(databaseValue: String?): List<CurrencyItem>? {
        return adapter.fromJson(databaseValue ?: "[]") ?: emptyList()
    }
}