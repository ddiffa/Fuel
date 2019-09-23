package com.example.fuel.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fuel.room.dao.NewsDao
import com.example.fuel.room.entity.NewsEntity

@Database(entities = [(NewsEntity::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsListDao(): NewsDao
}