package com.example.coinsmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.coinsmvvm.R
import com.example.coinsmvvm.databinding.CardviewMarketBinding
import com.example.coinsmvvm.model.Coins.Coins
import kotlin.math.abs

class CoinsAdapter : ListAdapter<Coins, CoinsAdapter.ViewHolder>(MyDiffItemCallback()) {
    class ViewHolder(val binding: CardviewMarketBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardviewMarketBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            txtname.text = data.name
            txtprice.text = "$%.5f".format(data.price.toFloat())
            txtsym.text = data.symbol
            txtchange.text =  abs(data.change.toFloat()).toString()
            if (data.change.toFloat() > 0) {
                imgarrow.setImageResource(R.drawable.ic_baseline_arrow_upward_24)
            } else {
                imgarrow.setImageResource(R.drawable.ic_baseline_arrow_downward_24)
            }
            imgicon.loadImage(data.iconUrl)
        }

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("uuid" to data.uuid)
            holder.itemView.findNavController().navigate(R.id.action_marketFragment2_to_coinDetailFragment,bundle)
        }

    }

    internal class MyDiffItemCallback : DiffUtil.ItemCallback<Coins>() {
        override fun areItemsTheSame(oldItem: Coins, newItem: Coins): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: Coins, newItem: Coins): Boolean {
            return oldItem == newItem
        }

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


