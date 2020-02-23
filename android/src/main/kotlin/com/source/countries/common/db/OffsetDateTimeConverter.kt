package com.source.countries.common.db

import io.objectbox.converter.PropertyConverter
import org.threeten.bp.OffsetDateTime


private val noOffsetDateTime = OffsetDateTime.MIN.toString()

class OffsetDateTimeConverter : PropertyConverter<OffsetDateTime, String?> {

    override fun convertToDatabaseValue(entityProperty: OffsetDateTime?): String? {
        return entityProperty?.toString()
    }

    override fun convertToEntityProperty(databaseValue: String?): OffsetDateTime {
        return OffsetDateTime.parse(databaseValue ?: noOffsetDateTime)
    }

}