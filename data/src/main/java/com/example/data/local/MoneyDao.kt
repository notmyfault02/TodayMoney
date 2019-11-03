package com.example.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.data.entities.Money
import io.reactivex.Completable

@Dao
interface MoneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoney(vararg: Money): Completable

    @Query("SELECT * FROM Money")
    fun getMoney(): LiveData<List<Money>>

    @Delete
    fun deleteRecord(vararg: Money)
}