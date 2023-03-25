package com.firas.dictionaryapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.firas.dictionaryapp.data.remote.dto.LicenseDto
import com.firas.dictionaryapp.data.remote.dto.MeaningDto
import com.firas.dictionaryapp.data.remote.dto.PhoneticDto
import com.firas.dictionaryapp.domaine.model.Meaning
import com.firas.dictionaryapp.domaine.model.Phonetic
import com.firas.dictionaryapp.domaine.model.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
   // val phonetics: List<Phonetic>,
    val word: String,
    @PrimaryKey()
    val id: Int? = null
){
    fun toWordInfo() : WordInfo{
        return WordInfo(
            meanings = meanings,
            //phonetics = phonetics,
            word=word
        )
    }
}
