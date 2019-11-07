package com.example.data.entities

data class Token(
    var access_token: String,
    var token_type: String,
    var expires_in: String,
    var scope: String,
    var user_seq_no: String
)