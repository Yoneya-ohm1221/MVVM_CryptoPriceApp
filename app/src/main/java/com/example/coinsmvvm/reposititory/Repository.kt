package com.example.coinsmvvm.reposititory

import com.example.coinsmvvm.model.Coin.CoinRes
import com.example.coinsmvvm.model.Coins.CoinsRes
import com.example.coinsmvvm.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private var apiService: ApiService) {

    suspend fun getCoins():Response<CoinsRes>{
        return apiService.getAllCoins()
    }

    suspend fun getDetail(uuid:String):Response<CoinRes>{
        return apiService.getDetailCoin(uuid)
    }
}