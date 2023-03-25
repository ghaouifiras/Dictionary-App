package com.firas.dictionaryapp.domaine.model

import com.firas.dictionaryapp.data.remote.dto.DefinitionDto

data class Meaning(
    val antonyms: List<String>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
)
