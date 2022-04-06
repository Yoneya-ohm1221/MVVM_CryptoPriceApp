package com.example.coinsmvvm.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinsmvvm.model.Coins.Coins
import com.example.coinsmvvm.reposititory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel
@Inject
constructor(private val repository: Repository) : ViewModel(){

    private val _coin = MutableLiveData<List<Coins>>()
    val coin :LiveData<List<Coins>>
        get() = _coin

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getCoins()
            if (res.isSuccessful){
               _coin.postValue(res.body()?.data?.coins)
            }
        }
    }
}