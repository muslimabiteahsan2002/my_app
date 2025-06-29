package com.muslima.myrac.amimal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muslima.myrac.FullActivity
import com.muslima.myrac.FullActivity.Companion.bio
import com.muslima.myrac.FullActivity.Companion.img
import com.muslima.myrac.FullActivity.Companion.name
import com.muslima.myrac.databinding.AnimalItemBinding

class AnimalAdapter(private val context: Context) :
    ListAdapter<AllAnimals, AnimalAdapter.AnimalViewHolder>(comparator) {
    class AnimalViewHolder(val binding: AnimalItemBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {
        val comparator = object : DiffUtil.ItemCallback<AllAnimals>() {
            override fun areItemsTheSame(oldItem: AllAnimals, newItem: AllAnimals): Boolean {
                return oldItem.animalName == newItem.animalName
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: AllAnimals, newItem: AllAnimals): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            AnimalItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        getItem(position).let {
            with(holder.binding) {
                cardTitle.text = it.animalName
                cardDescription.text = it.animalBio
                Glide.with(context)
                    .load(it.animalImg)
                    .into(cardImage)
            }
            holder.itemView.setOnClickListener {_->
                val item=Intent(context,FullActivity::class.java)
                item.putExtra(img,it.animalImg)
                item.putExtra(bio,it.animalBio)
                item.putExtra(name,it.animalName)
                context.startActivity(item)
            }
        }
    }
}