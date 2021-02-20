package com.example.mvvm_template.view.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_template.databinding.TestBinding
import com.example.mvvm_template.databinding.TestBindingImpl
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class SearchBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val TAG = "SearchBar"
    val searchBarBinding: TestBinding = TestBinding.inflate(LayoutInflater.from(context), this, true)

    val editTextLiveData = MutableLiveData<String>()

    init {
        //todo
    }

}