package com.example.mvvm_template.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_template.databinding.PersonItemBinding
import com.example.mvvm_template.model.model.Person

class PersonListAdapter : RecyclerView.Adapter<PersonListAdapter.ItemHolder>() {

    var list = ArrayList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolder(PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(private val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Person) {
            binding.item = item
        }
    }
}