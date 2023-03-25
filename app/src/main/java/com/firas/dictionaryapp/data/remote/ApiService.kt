package com.firas.dictionaryapp.data.remote

import com.firas.dictionaryapp.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getListWordInfo(@Path("word") word : String): List<WordInfoDto>

}