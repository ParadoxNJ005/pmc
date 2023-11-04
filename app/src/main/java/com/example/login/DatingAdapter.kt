package com.example.login

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login.databinding.ItemUserLayoutBinding
import com.bumptech.glide.Glide // Added import

class DatingAdapter(val context : Context, val list : ArrayList<UserModelClass>) : RecyclerView.Adapter<DatingAdapter.DatingViewHolder>(){
    inner class  DatingViewHolder(val binding : ItemUserLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatingViewHolder {
        return DatingViewHolder(ItemUserLayoutBinding.inflate(
            LayoutInflater.from(context),
            parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DatingViewHolder, position: Int) {

        holder.binding.textView10.text = list[position].breed_name
        holder.binding.textView9.text = list[position].bio

        Glide.with(context).load(list[position].image).into(holder.binding.UserImage)
    }
}