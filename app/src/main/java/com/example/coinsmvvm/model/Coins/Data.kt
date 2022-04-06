package com.example.coinsmvvm.model.Coins


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("coins")
    val coins: List<Coins>,
    @SerializedName("stats")
    val stats: Stats
)