package com.firas.dictionaryapp.data.remote.repository

import android.util.Log
import com.firas.dictionaryapp.common.Resource
import com.firas.dictionaryapp.data.local.dao.WordInfoDao
import com.firas.dictionaryapp.data.remote.ApiService
import com.firas.dictionaryapp.domaine.model.WordInfo
import com.firas.dictionaryapp.domaine.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: WordInfoDao

) : Repository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())
        val wordInfoData = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfoData))

        try {
            emit(Resource.Loading())
            val wordInfoDataFromApi = apiService.getListWordInfo(word)
            dao.deleteWordInfos(wordInfoDataFromApi.map { it.word })
            dao.insertWord(wordInfoDataFromApi.map { it.toWordInfoEntity() })

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = wordInfoData
                )
            )
        } catch (e: IOException) {

            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = wordInfoData
                )
            )

        }
        val newWordInfos = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))


    }

}