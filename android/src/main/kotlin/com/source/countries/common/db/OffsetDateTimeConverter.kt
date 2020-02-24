package com.source.countries.common.db

import androidx.room.TypeConverter
import org.threeten.bp.OffsetDateTime


private val noOffsetDateTime = OffsetDateTime.MIN.toString()

class OffsetDateTimeConverter{
    @TypeConverter
    fun convertToDatabaseValue(entityProperty: OffsetDateTime?): String? {
        return entityProperty?.toString()
    }

    @TypeConverter
    fun convertToEntityProperty(databaseValue: String?): OffsetDateTime? {
        return OffsetDateTime.parse(databaseValue ?: noOffsetDateTime)
    }
}