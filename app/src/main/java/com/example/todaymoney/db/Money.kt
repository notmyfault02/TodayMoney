package com.example.todaymoney.db

import androidx.room.Entity

@Entity
data class Money(
    var reason: String,
    var how: String,
    var money: Int,
    var date: String
)