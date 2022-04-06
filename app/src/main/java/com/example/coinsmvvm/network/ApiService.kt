package com.example.coinsmvvm.network

import com.example.coinsmvvm.model.Coins.CoinRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    //@Headers("x-access-token : coinrankingae776ccf8b7ce0fdff35301d9739d91709ba832291f7b4f1")
    @GET("coins?x-access-token=coinrankingae776ccf8b7ce0fdff35301d9739d91709ba832291f7b4f1")
    suspend fun getAllCoins() :Response<CoinRes>
}