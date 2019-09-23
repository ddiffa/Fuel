package com.example.fuel.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.fuel.repository.NewsRepository

import com.example.fuel.room.AppDatabase
import com.example.fuel.room.dao.NewsDao
import com.example.fuelapi.Api
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        val database: AppDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app.db")
                .allowMainThreadQueries()
                .build()
        bind<NewsDao>() with singleton { database.newsListDao() }
        bind<NewsRepository>() with singleton { NewsRepository(applicationContext) }
        bind<Api>() with singleton { Api() }
        bind<SharedPreferences>() with instance(getSharedPreferences("news_preference",Context.MODE_PRIVATE))

    }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}