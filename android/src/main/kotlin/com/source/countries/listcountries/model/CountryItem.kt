package com.source.countries.listcountries.model

import com.source.countries.common.db.ListStringConverter
import com.source.countries.common.db.OffsetDateTimeConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import org.threeten.bp.OffsetDateTime


@Entity
data class CountryItem(
    @Id var id: Long = 0L,
    val name: String,
    @Convert(converter = OffsetDateTimeConverter::class, dbType = String::class)
    val createdAt: OffsetDateTime,
    @Convert(converter = ListStringConverter::class, dbType = String::class)
    val topLevelDomain: List<String>,
    @Convert(converter = ListStringConverter::class, dbType = String::class)
    val callingCodes: List<String>
) {
    lateinit var currencies: ToMany<CurrencyItem>
}


@Suppress("NOTHING_TO_INLINE")
inline fun Country.toItem(): CountryItem {
    val item = CountryItem(
        id = 0L,
        name = name ?: "",
        createdAt = OffsetDateTime.now(),
        topLevelDomain = topLevelDomain ?: emptyList(),
        callingCodes = callingCodes ?: emptyList()
    )

    val providedCurrencies = currencies?.toItemList() ?: emptyList()
    return item.apply {
        currencies.addAll(providedCurrencies)
    }
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