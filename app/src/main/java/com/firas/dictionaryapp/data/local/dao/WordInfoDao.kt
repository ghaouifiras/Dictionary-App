package com.firas.dictionaryapp.data.local.dao

import androidx.room.*
import com.firas.dictionaryapp.data.local.entities.WordInfoEntity

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(items: List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
    suspend fun deleteWordInfos(words: List<String>)

    @Query("SELECT * FROM WordInfoEntity WHERE word LIKE  :word ")
    suspend fun getWordInfo(word: String): List<WordInfoEntity>


}