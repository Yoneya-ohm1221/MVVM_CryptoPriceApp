package com.example.coinsmvvm.network

import com.example.coinsmvvm.model.Coin.CoinRes
import com.example.coinsmvvm.model.Coins.CoinsRes
import com.example.coinsmvvm.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @GET("coins?x-access-token=coinrankingae776ccf8b7ce0fdff35301d9739d91709ba832291f7b4f1")
    suspend fun getAllCoins() :Response<CoinsRes>

    @GET("coin/{uuid}?x-access-token=$API_KEY")
    suspend fun getDetailCoin(
        @Path("uuid") uuid:String
    ) :Response<CoinRes>
}