package com.example.todaymoney.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.local.AppDatabase
import com.example.data.entities.Money
import com.example.todaymoney.MainAdapter
import com.example.todaymoney.R
import com.example.todaymoney.ui.add.AddActivity
import com.example.todaymoney.ui.add.AddViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var appDB: AppDatabase? = null

    private lateinit var viewModel: AddViewModel

    var items = listOf<Money>()

    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainAdapter = MainAdapter(this@MainActivity, items)

        var btn = findViewById<Button>(R.id.main_add_btn)
        appDB = AppDatabase.getInstance(this)
        mainAdapter = MainAdapter(this, items)

        val mainLayoutManager = LinearLayoutManager(this)
        mainLayoutManager.reverseLayout
        mainLayoutManager.stackFromEnd

        rv_main.adapter = mainAdapter
        rv_main.layoutManager = mainLayoutManager
        rv_main.setHasFixedSize(true)

        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        viewModel.getAll().observe(this, Observer<List<Money>> { money ->
            mainAdapter.setRecord(money)
        })

        btn.onClick {
            onPopup()
        }

    }

    fun onPopup() {
        startActivity<AddActivity>()
    }
}
