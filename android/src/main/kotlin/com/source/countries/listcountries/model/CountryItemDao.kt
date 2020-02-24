package com.source.countries.listcountries.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryItemDao {
    @Query("SELECT * FROM CountryItem")
    fun all(): List<CountryItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(countries: List<CountryItem>)

    @Query("DELETE FROM CountryItem")
    fun removeAll()
}