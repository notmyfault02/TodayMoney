package com.example.todaymoney

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todaymoney.db.Money

class MainAdapter(val context: Context, val items: Array<Money>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_money, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

    inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind() {

        }

    }
}