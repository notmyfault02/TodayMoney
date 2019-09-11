package com.example.todaymoney.ui

import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.data.db.AppDatabase
import com.example.data.entities.Money
import com.example.todaymoney.R
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*

class AddActivity : AppCompatActivity() {

    private var appDb: AppDatabase? = null

    val calendar = GregorianCalendar(Locale.KOREA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_add)

        appDb = AppDatabase.getInstance(this)

        var addRunnable =  Runnable {
            val newRecord = Money()
            newRecord.reason = add_reason_et.text.toString()
            newRecord.money = add_money_et.text.toString()
            newRecord.date = "${calendar.get(GregorianCalendar.YEAR)}.${calendar.get(GregorianCalendar.MONTH)}.${calendar.get(GregorianCalendar.DATE)}"
            newRecord.how = add_how_spn.selectedItem.toString()
            Log.d("addActivity", newRecord.how)
            appDb?.MoneyDao()?.insertMoney(newRecord)
        }

        add_ok_btn.onClick {
            val thread = Thread(addRunnable)
            thread.start()
            finish()
        }
    }
}
