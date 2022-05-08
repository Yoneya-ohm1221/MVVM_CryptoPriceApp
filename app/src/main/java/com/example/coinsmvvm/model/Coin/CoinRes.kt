package com.example.coinsmvvm.model.Coin


import com.google.gson.annotations.SerializedName

data class CoinRes(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)