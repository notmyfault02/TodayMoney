package com.example.todaymoney.ui.add

import androidx.lifecycle.ViewModel
import com.example.data.db.MoneyDao
import com.example.data.entities.Money
import io.reactivex.Completable

class AddViewModel(private val dao: MoneyDao): ViewModel() {
    fun updateRecord(record: Money): Completable {
        return dao.insertMoney(record)
    }
}