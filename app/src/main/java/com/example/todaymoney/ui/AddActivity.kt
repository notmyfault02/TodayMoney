package com.example.todaymoney.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todaymoney.R
import com.example.todaymoney.db.AppDatabase
import com.example.todaymoney.db.Money
import java.util.*

class AddActivity : AppCompatActivity() {

    private var appDb: AppDatabase? = null

    val calendar = GregorianCalendar(Locale.KOREA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        appDb = AppDatabase.getInstance(this)

        var addRunnable =  Runnable {
            val newRecord = Money()
            //newRecord.reason =
        }
    }
}
