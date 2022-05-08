package com.example.coinsmvvm.ui

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coinsmvvm.R
import com.example.coinsmvvm.databinding.FragmentCoinDetailBinding
import com.example.coinsmvvm.utils.Resource
import com.example.coinsmvvm.viewModels.CoinDetailViewModel
import com.example.coinsmvvm.viewModels.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailFragment : Fragment() {

    lateinit var binding: FragmentCoinDetailBinding
    private val coinDetailViewModel:CoinDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgback.setOnClickListener {
            activity?.onBackPressed()
        }
        val uuid = arguments?.getString("uuid")
       coinDetailViewModel.getDetail(uuid!!)
        setUi()
    }

    private fun setUi(){
        coinDetailViewModel.coinDetail.observe(viewLifecycleOwner){ resources->
            when (resources) {
                is  Resource.Success -> {
                    binding.apply {
                        txtnamed.text = resources.data!!.name
                        txtsmd.text = resources.data!!.symbol
                        txtdis.text =   Html.fromHtml( resources.data!!.description)
                        viewFlipper.displayedChild = 0
                    }
                }
                is Resource.Loading ->{
                    binding.viewFlipper.displayedChild =1
                }

                is Resource.Error ->{
                    activity?.onBackPressed()
                }
            }

        }
    }

}