package com.example.todaymoney.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.data.entities.Money
import com.example.data.local.MoneyDao
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable

class AddViewModel(app: Application, private val dao: MoneyDao): AndroidViewModel(app) {

    private val repository = AddRepository(app)
    private val moneys = repository.getAll()
    val disposable = CompositeDisposable()

    fun getAll(): LiveData<List<Money>> {
        return this.moneys
    }

    fun updateRecord(record: Money): Completable {
        return dao.insertMoney(record)
    }

    fun delete(money: Money) {
        repository.delete(money)
    }
}