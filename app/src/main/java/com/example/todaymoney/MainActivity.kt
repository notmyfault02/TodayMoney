package com.example.todaymoney

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.db.AppDatabase
import com.example.data.entities.Money
import com.example.todaymoney.ui.AddActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var appDB: AppDatabase? = null

    var items = listOf<Money>()

    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.main_add_btn)
        appDB = AppDatabase.getInstance(this)
        mainAdapter = MainAdapter(this, items)

        val mainLayoutManager = LinearLayoutManager(this)
        mainLayoutManager.reverseLayout
        mainLayoutManager.stackFromEnd

        var loadRunnable = Runnable {
            try {
                items = appDB?.MoneyDao()?.getMoney()!!
                mainAdapter = MainAdapter(this@MainActivity, items)
                mainAdapter.notifyDataSetChanged()

                rv_main.adapter = mainAdapter
                rv_main.layoutManager = mainLayoutManager
            } catch (e: Exception) {
                Log.d("main", e.toString())
            }
        }

        val thread = Thread(loadRunnable)
        thread.start()

        btn.onClick {
            onPopup()
        }

    }

    fun onPopup() {
        startActivity<AddActivity>()
    }
}
