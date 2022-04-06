package com.example.coinsmvvm.model.Coins


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("bestCoins")
    val bestCoins: List<BestCoin>,
    @SerializedName("btcDominance")
    val btcDominance: Double,
    @SerializedName("newestCoins")
    val newestCoins: List<NewestCoin>,
    @SerializedName("referenceCurrencyRate")
    val referenceCurrencyRate: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total24hVolume")
    val total24hVolume: String,
    @SerializedName("totalCoins")
    val totalCoins: Int,
    @SerializedName("totalExchanges")
    val totalExchanges: Int,
    @SerializedName("totalMarketCap")
    val totalMarketCap: String,
    @SerializedName("totalMarkets")
    val totalMarkets: Int
)