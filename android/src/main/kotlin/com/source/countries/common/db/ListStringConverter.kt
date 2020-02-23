package com.source.countries.common.db

import io.objectbox.converter.PropertyConverter


private const val listSeparator = "@!,"

class ListStringConverter : PropertyConverter<List<String>, String> {
    override fun convertToDatabaseValue(entityProperty: List<String>?): String {
        return entityProperty?.joinToString(separator = listSeparator) ?: ""
    }

    override fun convertToEntityProperty(databaseValue: String?): List<String> {
        return databaseValue?.split(listSeparator) ?: emptyList()
    }
}