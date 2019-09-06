package com.example.todaymoney.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todaymoney.db.dao.MoneyDao

@Database(entities = [Money::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun MoneyDao(): MoneyDao

    companion object {

    }
}