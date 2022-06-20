package com.example.kotlin1homework3.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1homework3.databinding.ItemEpisodeBinding
import com.example.kotlin1homework3.model.EpisodeModel

class EpisodeAdapter(
    private val onItemClick: (id: Int) -> Unit

) : PagingDataAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EpisodeModel?) {
            binding.itemEpisodeName.text = item?.name
            binding.itemEpisodeAirDate.text = item?.air_date
            binding.itemEpisodeEpisode.text = item?.episode
        }

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply {
                    onItemClick(id)
                }
            }
        }
    }

    companion object {
        private val diffCallback: DiffUtil.ItemCallback<EpisodeModel> =
            object : DiffUtil.ItemCallback<EpisodeModel>() {
                override fun areItemsTheSame(
                    oldItem: EpisodeModel,
                    newItem: EpisodeModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: EpisodeModel,
                    newItem: EpisodeModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}