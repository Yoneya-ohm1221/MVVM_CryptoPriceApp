package com.example.coinsmvvm.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.coinsmvvm.R
import com.example.coinsmvvm.adapter.CoinsAdapter
import com.example.coinsmvvm.databinding.FragmentMarketBinding
import com.example.coinsmvvm.model.Coins.Coins
import com.example.coinsmvvm.utils.Resource
import com.example.coinsmvvm.viewModels.CoinViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

@AndroidEntryPoint
class MarketFragment : Fragment() {

    lateinit var binding: FragmentMarketBinding
    lateinit var navController: NavController
    private val coinViewModel: CoinViewModel by viewModels()
    lateinit var coinsAdapter: CoinsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMarketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        coinsAdapter = CoinsAdapter()
        binding.recycleView.adapter = coinsAdapter

        setUi()

    }

    private fun setUi() {
        coinViewModel.coin.observe(viewLifecycleOwner) {
            it.let { resources ->
                when (resources) {
                    is Resource.Success -> {
                        binding.viewFlipper.displayedChild = 1
                        coinsAdapter.submitList(resources.data)

                       // resources.data.minByOrNull { 0 - it.price.toFloat()  }


                    }

                    is Resource.Loading -> {
                        binding.viewFlipper.displayedChild = 0
                    }

                    is Resource.Error -> {
                        binding.viewFlipper.displayedChild = 0
                        view?.snack(resources.message!!)
                    }
                }
            }

        }

    }


    private fun View.snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
        Snackbar.make(this, message, duration).show()
    }

    private fun ImageView.loadImage(imageUri: String, placeholder: Int? = null) {

        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadImage.context)) }
            .build()

        load(uri = imageUri, imageLoader = imageLoader) {
            crossfade(true)

        }
    }
}