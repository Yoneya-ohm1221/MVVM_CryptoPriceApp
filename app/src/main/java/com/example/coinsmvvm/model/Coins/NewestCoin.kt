package com.example.coinsmvvm.model.Coins


import com.google.gson.annotations.SerializedName

data class NewestCoin(
    @SerializedName("coinrankingUrl")
    val coinrankingUrl: String,
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("uuid")
    val uuid: String
)