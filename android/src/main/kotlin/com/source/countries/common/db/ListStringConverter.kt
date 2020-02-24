package com.source.countries.common.db

import androidx.room.TypeConverter


private const val listSeparator = "@!,"

class ListStringConverter {
    @TypeConverter
    fun convertToDatabaseValue(entityProperty: List<String>?): String? {
        return entityProperty?.joinToString(separator = listSeparator) ?: ""
    }

    @TypeConverter
    fun convertToEntityProperty(databaseValue: String?): List<String>? {
        return databaseValue?.split(listSeparator) ?: emptyList()
    }
}