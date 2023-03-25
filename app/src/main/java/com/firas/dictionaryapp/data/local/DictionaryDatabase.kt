package com.firas.dictionaryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.firas.dictionaryapp.data.local.dao.WordInfoDao
import com.firas.dictionaryapp.data.local.entities.WordInfoEntity

@Database(
    version = 1,
    entities = [WordInfoEntity::class]
)
@TypeConverters(Converters::class)

abstract class DictionaryDatabase : RoomDatabase() {
    abstract val dao: WordInfoDao
}