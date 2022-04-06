package com.example.coinsmvvm.model.Coins


import com.google.gson.annotations.SerializedName

data class Coins(
    @SerializedName("btcPrice")
    val btcPrice: String,
    @SerializedName("change")
    val change: String,
    @SerializedName("coinrankingUrl")
    val coinrankingUrl: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("24hVolume")
    val hVolume: String,
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("listedAt")
    val listedAt: String,
    @SerializedName("lowVolume")
    val lowVolume: Boolean,
    @SerializedName("marketCap")
    val marketCap: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("sparkline")
    val sparkline: List<String>,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tier")
    val tier: String,
    @SerializedName("uuid")
    val uuid: String
)