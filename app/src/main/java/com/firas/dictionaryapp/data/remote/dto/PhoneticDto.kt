package com.firas.dictionaryapp.data.remote.dto

import com.firas.dictionaryapp.domaine.model.Phonetic

data class PhoneticDto(
    val audio: String,
    val license: LicenseDto,
    val sourceUrl: String,
    val text: String
) {
    fun toPhonetic(): Phonetic {
        return Phonetic(
            text = text
        )
    }
}