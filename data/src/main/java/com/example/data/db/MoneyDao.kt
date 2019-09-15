package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.entities.Money
import io.reactivex.Completable

@Dao
interface MoneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoney(vararg: Money): Completable

    @Query("SELECT * FROM Money")
    fun getMoney(): List<Money>

    @Query("DELETE FROM Money")
    fun deleteAllRecord()
}