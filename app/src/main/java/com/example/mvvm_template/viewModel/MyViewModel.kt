package com.example.mvvm_template.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_template.model.api.MyAPIService
import com.example.mvvm_template.viewModel.mapper.PersonMapper
import com.example.mvvm_template.model.model.Person
import com.example.mvvm_template.model.model.Result
import com.example.mvvm_template.util.Event
import com.example.mvvm_template.viewModel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class MyViewModel(
    private val myApi: MyAPIService
) : BaseViewModel() {

    private val TAG = "MyViewModel"

    private val _personData = MutableLiveData<List<Person>>()
    val personData: LiveData<List<Person>>
        get() = _personData

    fun search(argument1 : String, argument2 : String){
        myApi.search(argument1, argument2)
            .subscribeOn(Schedulers.io())
            .map(PersonMapper::map)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                when (it) {
                    is Result.Success -> _personData.value = it.data!!
                    is Result.Failure -> {
                        Log.d(TAG, "Result.Failure = ${it.exception.toString()}")
                        callServerError()
                    }
                }
            },{
                Log.d(TAG, "Rx Throwable = ${it.toString()}")
                callNetworkError()
            })
    }

    private fun callNetworkError() {
        _error.value = Event("network")
    }
    private fun callServerError() {
        _error.value = Event("server")
    }
}