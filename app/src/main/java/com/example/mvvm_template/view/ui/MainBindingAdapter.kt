package com.example.mvvm_template.view.ui

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.annotation.Dimension
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_template.model.dataModel.Person
import com.example.mvvm_template.view.adapter.PersonListAdapter
import com.example.mvvm_template.view.ui.customview.SearchBar
import com.example.mvvm_template.viewModel.MyViewModel
import kotlinx.android.synthetic.main.test.view.*



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

@BindingAdapter("flexibleText")
fun setEditTextText(
    view : SearchBar,
    text : String
){
    val length = text.length
    when {
        (length in 0..12) -> {
            view.searchBarBinding.editText.setTextSize(Dimension.SP, 40F)
        }
        (length in 13..25) -> {
            view.searchBarBinding.editText.setTextSize(Dimension.SP, 20F)
        }
        else -> {
            view.searchBarBinding.editText.setTextSize(Dimension.SP, 10F)
        }
    }
}

@BindingAdapter("flexibleTextAttrChanged")
fun setEditTextBindingListener(view: SearchBar, listener: InverseBindingListener) {
    view.searchBarBinding.editText.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            listener.onChange()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {        }
    })
}

@InverseBindingAdapter(attribute = "flexibleText", event = "flexibleTextAttrChanged")
fun getEditTextText(view: SearchBar): String {
    return view.searchBarBinding.editText.text.toString()
}