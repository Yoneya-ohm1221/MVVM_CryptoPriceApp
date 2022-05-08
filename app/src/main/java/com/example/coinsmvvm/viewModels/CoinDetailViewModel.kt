package com.example.coinsmvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinsmvvm.model.Coin.Coin
import com.example.coinsmvvm.model.Coins.Coins
import com.example.coinsmvvm.reposititory.Repository
import com.example.coinsmvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _coinDetail = MutableLiveData<Resource<Coin>>()
    val coinDetail: LiveData<Resource<Coin>>
        get() = _coinDetail



    fun getDetail(uuid:String){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _coinDetail.postValue(Resource.Loading())
                val res = repository.getDetail(uuid)
                if (res.isSuccessful){
                    _coinDetail.postValue(Resource.Success(res.body()!!.data.coin))
                }else{
                    _coinDetail.postValue(Resource.Error("connection fail"))
                }
            }catch (e:Exception){

            }

        }

    }
}