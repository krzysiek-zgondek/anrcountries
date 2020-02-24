package com.source.countries

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.source.countries.common.db.ListStringConverter
import com.source.countries.common.db.OffsetDateTimeConverter
import com.source.countries.listcountries.db.ListCurrencyConverter
import com.source.countries.listcountries.model.CountryItem
import com.source.countries.listcountries.model.CountryItemDao

@Database(entities = [CountryItem::class], version = 1, exportSchema = false)
@TypeConverters(
    ListStringConverter::class,
    OffsetDateTimeConverter::class,
    ListCurrencyConverter::class
)
abstract class CountriesDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryItemDao

    companion object{
        const val Name = "countries.db"
    }
}