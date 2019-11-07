package com.example.data.entities

data class Balance(
    var api_tran_id: String,
    var rsp_code: String,
    var rsp_message: String,
    var api_tran_dtm: String,
    var bank_tran_id: String,
    var bank_tran_date: String,
    var bank_code_tran: String,
    var bank_rsp_code: String,
    var bank_rsp_message: String,
    var fintech_use_num: String,
    var balance_amt: String,
    var account_type: String,
    var product_name: String
)