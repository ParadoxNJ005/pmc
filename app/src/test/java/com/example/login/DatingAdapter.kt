package com.example.login

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login.databinding.ItemUserLayoutBinding
import org.junit.runner.manipulation.Ordering.Context


class DatingAdapter(val context : Context,val list : ArrayList<UserModel>) : RecyclerView.Adapter<DatingAdapter.DatingViewHolder>(){
    inner class  DatingViewHolder(val binding : ItemUserLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatingViewHolder {
        return DatingViewHolder(ItemUserLayoutBinding.inflate(LayoutInflator.from(context),
            parent,false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: DatingViewHolder, position: Int) {

        holder.binding.textView10.text = list[position].name
        holder.binding.textView9.text = list[position].email

        Glide.with(context).load(list[position].image).into(holder.binding.UserImage)
    }
}