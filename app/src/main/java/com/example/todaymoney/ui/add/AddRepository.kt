package com.example.todaymoney.ui.add

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.data.entities.Money
import com.example.data.local.AppDatabase
import com.example.data.local.MoneyDao

class AddRepository(application: Application) {

    private val database = AppDatabase.getInstance(application)!!
    private val moneyDao: MoneyDao = database.MoneyDao()
    private val moneys: LiveData<List<Money>> = database.MoneyDao().getMoney()

    fun getAll(): LiveData<List<Money>> {
        return moneys
    }

    fun insert(money: Money) {
        try {
            val thread = Thread( Runnable {
                moneyDao.insertMoney(money) })
            thread.start()
        } catch (e: Exception) {}
    }

    fun delete(money: Money) {
        try {
            val thread = Thread( Runnable {
                moneyDao.deleteRecord(money)
            })
        } catch (e: java.lang.Exception) {}
    }
}