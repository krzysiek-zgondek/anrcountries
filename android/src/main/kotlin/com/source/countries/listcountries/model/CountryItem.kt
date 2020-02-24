package com.source.countries.listcountries.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.source.countries.listcountries.db.ListCurrencyConverter
import com.source.countries.common.db.ListStringConverter
import com.source.countries.common.db.OffsetDateTimeConverter
import org.threeten.bp.OffsetDateTime


@Entity
data class CountryItem(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    @TypeConverters(OffsetDateTimeConverter::class)
    val createdAt: OffsetDateTime,
    @TypeConverters(ListStringConverter::class)
    val topLevelDomain: List<String>,
    @TypeConverters(ListStringConverter::class)
    val callingCodes: List<String>,
    @TypeConverters(ListCurrencyConverter::class)
    val currencies: List<CurrencyItem>
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

@Suppress("NOTHING_TO_INLINE")
inline fun CountryItem.toModel(): CountryModel {
    return CountryModel(
        name = name,
        createdAt = createdAt,
        topLevelDomain = topLevelDomain,
        callingCodes = callingCodes,
        currencies = currencies.toModelList()
    )
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<CountryItem>.toModelList(): List<CountryModel> {
    return map(CountryItem::toModel)
}