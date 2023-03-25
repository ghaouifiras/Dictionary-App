package com.firas.dictionaryapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.firas.dictionaryapp.data.utils.JsonParser
import com.firas.dictionaryapp.domaine.model.Meaning
import com.firas.dictionaryapp.domaine.model.Phonetic
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromPhoneticsJson(json: String): List<Phonetic> {
        return jsonParser.fromJson<ArrayList<Phonetic>>(
            json,
            object : TypeToken<ArrayList<Phonetic>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toPhoneticsJson(meanings: List<Phonetic>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Phonetic>>() {}.type
        ) ?: "[]"
    }


}