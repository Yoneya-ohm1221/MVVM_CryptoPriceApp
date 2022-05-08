package com.example.coinsmvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinsmvvm.model.Coins.Coins
import com.example.coinsmvvm.reposititory.Repository
import com.example.coinsmvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel
@Inject
constructor(private val repository: Repository) : ViewModel() {

    private val _coin = MutableLiveData<Resource<List<Coins>>>()
    val coin: LiveData<Resource<List<Coins>>>
        get() = _coin

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
               // while (true){
                    val res = repository.getCoins()
                    _coin.postValue(Resource.Loading())
                    if (res.isSuccessful) {
                        _coin.postValue(Resource.Success(res.body()!!.data.coins))
                    } else {
                        _coin.postValue(Resource.Error(res.message()))
                    }
                   // delay(10000)
               // }

            } catch (e: Exception) {
                _coin.postValue(Resource.Error("connect fail"))
            }


        }
    }
}