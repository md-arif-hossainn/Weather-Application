package com.arif.hossain.weatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arif.hossain.weatherapp.databinding.ForecastItemRowBinding
import com.arif.hossain.weatherapp.models.ForecastModel

class ForecastAdapter : ListAdapter<ForecastModel.ForecastItem, ForecastAdapter.ForecastViewholder>(ForecastDiffUtil()){

    class ForecastViewholder(val binding: ForecastItemRowBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item: ForecastModel.ForecastItem) {
                    binding.item = item
                }
            }

    class ForecastDiffUtil : DiffUtil.ItemCallback<ForecastModel.ForecastItem>() {
        override fun areItemsTheSame(
            oldItem: ForecastModel.ForecastItem,
            newItem: ForecastModel.ForecastItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastModel.ForecastItem,
            newItem: ForecastModel.ForecastItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewholder {
        val binding = ForecastItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ForecastViewholder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}