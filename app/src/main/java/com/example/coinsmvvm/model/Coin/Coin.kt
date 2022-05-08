package com.example.coinsmvvm.model.Coin


import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("allTimeHigh")
    val allTimeHigh: AllTimeHigh,
    @SerializedName("btcPrice")
    val btcPrice: String,
    @SerializedName("change")
    val change: String,
    @SerializedName("coinrankingUrl")
    val coinrankingUrl: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("24hVolume")
    val hVolume: String,
    @SerializedName("iconUrl")
    val iconUrl: String,
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("listedAt")
    val listedAt: Int,
    @SerializedName("lowVolume")
    val lowVolume: Boolean,
    @SerializedName("marketCap")
    val marketCap: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("numberOfExchanges")
    val numberOfExchanges: Int,
    @SerializedName("numberOfMarkets")
    val numberOfMarkets: Int,
    @SerializedName("price")
    val price: String,
    @SerializedName("priceAt")
    val priceAt: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("sparkline")
    val sparkline: List<String>,
    @SerializedName("supply")
    val supply: Supply,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tier")
    val tier: Int,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("websiteUrl")
    val websiteUrl: String
)