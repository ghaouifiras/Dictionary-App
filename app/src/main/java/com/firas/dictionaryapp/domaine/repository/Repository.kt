package com.firas.dictionaryapp.domaine.repository

import com.firas.dictionaryapp.common.Resource
import com.firas.dictionaryapp.domaine.model.WordInfo
import kotlinx.coroutines.flow.Flow


interface Repository {

    fun getWordInfo(word: String):Flow<Resource<List<WordInfo>>>


}