package com.example.data.entities

data class LoginResponse(
    var code: String,
    var scope :String,
    var client_info: String
)