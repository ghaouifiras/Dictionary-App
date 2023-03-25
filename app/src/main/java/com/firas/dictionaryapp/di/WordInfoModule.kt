package com.firas.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.firas.dictionaryapp.common.Constants
import com.firas.dictionaryapp.data.local.Converters
import com.firas.dictionaryapp.data.local.DictionaryDatabase
import com.firas.dictionaryapp.data.remote.ApiService
import com.firas.dictionaryapp.data.remote.repository.RepositoryImpl
import com.firas.dictionaryapp.data.utils.GsonParser
import com.firas.dictionaryapp.domaine.repository.Repository
import com.firas.dictionaryapp.domaine.use_cases.GetWordInfoUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): DictionaryDatabase {
        return Room.databaseBuilder(
            app, DictionaryDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: Repository): GetWordInfoUseCase {
        return GetWordInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: DictionaryDatabase,
        api: ApiService
    ): Repository {
        return RepositoryImpl(api, db.dao)
    }


}