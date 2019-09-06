package com.example.todaymoney

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todaymoney.db.Money
import kotlinx.android.synthetic.main.item_money.view.*

class MainAdapter(val context: Context, val items: List<Money>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Money) {
            with(view) {
                main_money_tv.text = item.money.toString()
                main_reason_tv.text = item.reason
                main_date_tv.text = item.date

            }
        }

    }
}