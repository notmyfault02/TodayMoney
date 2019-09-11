package com.example.todaymoney.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todaymoney.db.dao.MoneyDao

@Database(entities = [Money::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun MoneyDao(): MoneyDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "money.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}