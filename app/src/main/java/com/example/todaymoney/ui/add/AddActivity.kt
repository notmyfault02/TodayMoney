package com.example.todaymoney.ui.add

import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.data.local.AppDatabase
import com.example.data.entities.Money
import com.example.todaymoney.R
import com.example.todaymoney.databinding.ActivityAddBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.android.ext.android.inject
import java.util.*

class AddActivity : AppCompatActivity() {

    private val viewModel: AddViewModel by inject()

    private val disposable = CompositeDisposable()

    private var appDb: AppDatabase? = null

    val newRecord = Money()

    val calendar = GregorianCalendar(Locale.KOREA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_add)

        val binding = DataBindingUtil.setContentView<ActivityAddBinding>(this, R.layout.activity_add)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        appDb = AppDatabase.getInstance(this)

        add_ok_btn.onClick { updateRecord() }
    }

    fun updateRecord() {
        newRecord.reason = add_reason_et.text.toString()
        newRecord.money = add_money_et.text.toString()
        newRecord.date = "${calendar.get(GregorianCalendar.YEAR)}.${calendar.get(GregorianCalendar.MONTH)}.${calendar.get(GregorianCalendar.DATE)}"
        newRecord.how = add_how_spn.selectedItem.toString()
        newRecord.time = "${calendar.get(GregorianCalendar.HOUR)}:${calendar.get(GregorianCalendar.MINUTE)}"

        disposable.add(viewModel.updateRecord(newRecord)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                Log.d("addActivity", "okay")
            }, {
                Log.d("addActivity", it.message)
            }))
    }
}
