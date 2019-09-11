package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Money(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var reason: String,
    var how: String,
    var money: String,
    var date: String
) {
    constructor(): this(0,"", "", "", "")
}