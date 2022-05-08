package com.example.coinsmvvm.model.Coin


import com.google.gson.annotations.SerializedName

data class Supply(
    @SerializedName("circulating")
    val circulating: String,
    @SerializedName("confirmed")
    val confirmed: Boolean,
    @SerializedName("total")
    val total: String
)