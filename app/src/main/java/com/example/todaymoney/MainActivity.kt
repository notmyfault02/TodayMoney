package com.example.todaymoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todaymoney.db.Money
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var items = listOf<Money>()

    val mainAdapter: MainAdapter by lazy { MainAdapter(this, items) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_main.adapter = mainAdapter
        rv_main.layoutManager = LinearLayoutManager(this)

    }
}
