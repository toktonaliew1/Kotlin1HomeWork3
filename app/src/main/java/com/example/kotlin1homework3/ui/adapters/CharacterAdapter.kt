package com.example.kotlin1homework3.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin1homework3.databinding.ItemCharacterBinding
import com.example.kotlin1homework3.model.CharacterModel

class CharacterAdapter(
    private val onItemClick: (id: Int) -> Unit
) : PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterModel?) {
            binding.itemCharacterName.text = item?.name
            Glide.with(binding.itemCharacterImage).load(item?.image)
                .into(binding.itemCharacterImage)
            binding.itemCharacterObject.text = item?.origin.toString()
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
        private val diffCallback: DiffUtil.ItemCallback<CharacterModel> =
            object : DiffUtil.ItemCallback<CharacterModel>() {
                override fun areItemsTheSame(
                    oldItem: CharacterModel,
                    newItem: CharacterModel
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: CharacterModel,
                    newItem: CharacterModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}
