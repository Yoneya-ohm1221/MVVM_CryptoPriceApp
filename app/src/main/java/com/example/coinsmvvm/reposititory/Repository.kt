package com.example.coinsmvvm.reposititory

import android.util.Log
import com.example.coinsmvvm.model.Coins.CoinRes
import com.example.coinsmvvm.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private var apiService: ApiService) {

    suspend fun getCoins():Response<CoinRes>{
        return apiService.getAllCoins()
    }
}