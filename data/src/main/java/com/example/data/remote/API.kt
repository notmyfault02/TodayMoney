package com.example.data.remote

import com.example.data.entities.*
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {
    @GET("oauth/2.0/authorize")
    fun login(
        @Query("response_type") responseType: String,
        @Query("client_id") clientId: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("scope") scope: String,
        @Query("client_info") clientInfo: String
    ): Flowable<LoginResponse>

    @POST("oauth/2.0/token")
    fun getToken(
        @Body body: Any
    ): Flowable<Token>

    @GET("oauth/2.0/register_account")
    fun getAccount(
        @Query("response_type") responseType: String,
        @Query("client_id") clientId: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("scope") scope: String,
        @Query("client_info") clientInfo: String
    ): Flowable<AccountResponseData>

    @GET("oauth/2.0/authorize_account")
    fun confirmAccount(
        @Query("response_type") responseType: String,
        @Query("client_id") clientId: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("scope") scope: String,
        @Query("client_info") clientInfo: String
    ): Flowable<AccountResponseData>

    @GET("user/me")
    fun getUser(
        @Query("user_seq_no") userSeqNo: String
    ): Flowable<User>

    @GET("account/list")
    fun getAccountList(
        @Query("user_seq_no") userSeqNo: String,
        @Query("include_cancel_yn") includeCancelYn: String,
        @Query("sort_order") sortOrder: String
    ): Flowable<TransactionData>

    @GET("account/balance/")
    fun getBalance(
        @Query("fintech_use_num") fintechUseNum: String,
        @Query("tran_dtime") tranDtime: String
    ): Flowable<Balance>

    @GET("account/transaction_list")
    fun getTrancactionList(
        @Query("fintech_use_num") fintechUseNum: String,
        @Query("inquiry_type") inquiryType: String,
        @Query("from_date") fromDate: String,
        @Query("to_date") toDate: String,
        @Query("sort_order") sortOrder: String,
        @Query("page_index") pageIndex: String,
        @Query("tran_dtime") tranDtime: String
    ): Flowable<TransactionData>
}