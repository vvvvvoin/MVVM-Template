package com.example.mvvm_template.view.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_template.model.model.Person
import com.example.mvvm_template.view.adapter.PersonListAdapter


@BindingAdapter("item")
fun setList(
    recyclerView: RecyclerView,
    item: List<Person>?
){
    val personAdapter: PersonListAdapter
    if(recyclerView.adapter == null){
        return
    }else{
        personAdapter = recyclerView.adapter as PersonListAdapter
    }

    item?.let {
        personAdapter.list = it as ArrayList
        personAdapter.notifyDataSetChanged()
    }
}