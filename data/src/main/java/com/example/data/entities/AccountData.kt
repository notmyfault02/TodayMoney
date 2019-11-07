package com.example.data.entities

data class AccountData(
    var fintech_use_num: String,
    var account_alias: String,
    var bank_code_std: String,
    var bank_code_sub: String,
    var bank_name: String,
    var account_num_masked: String,
    var account_type: String,
    var inquiry_agree_yn: String,
    var inquiry_agree_dtime: String,
    var transfer_agree_yn: String,
    var transfer_agree_dtime: String,
    var account_state: String
)