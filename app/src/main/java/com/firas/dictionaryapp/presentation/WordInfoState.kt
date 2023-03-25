package com.firas.dictionaryapp.presentation

import com.firas.dictionaryapp.domaine.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
