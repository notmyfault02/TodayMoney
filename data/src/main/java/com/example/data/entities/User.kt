package com.example.data.entities

data class User(
    var api_tran_id: String,
    var rsp_code: String,
    var rsp_message: String,
    var api_tran_dtm: String,
    var user_name: String,
    var res_cnt: String,
    var res_list: ArrayList<AccountData>
)