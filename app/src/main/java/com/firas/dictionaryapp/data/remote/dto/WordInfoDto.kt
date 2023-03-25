package com.firas.dictionaryapp.data.remote.dto

import com.firas.dictionaryapp.data.local.entities.WordInfoEntity

data class WordInfoDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
           // phonetics = phonetics.map { it.toPhonetic() },
            word = word,
        )
    }

}