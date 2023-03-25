package com.firas.dictionaryapp.domaine.use_cases

import com.firas.dictionaryapp.common.Resource
import com.firas.dictionaryapp.domaine.model.WordInfo
import com.firas.dictionaryapp.domaine.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(private val repository: Repository) {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> {
        return if (word.isBlank()) {
            flow { }
        } else
            repository.getWordInfo(word)
    }
}