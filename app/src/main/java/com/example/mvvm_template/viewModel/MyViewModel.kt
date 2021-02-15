package com.example.mvvm_template.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_template.model.dataModel.Person
import com.example.mvvm_template.model.dataModel.Result
import com.example.mvvm_template.repository.RemoteRepository
import com.example.mvvm_template.util.Event
import com.example.mvvm_template.viewModel.base.BaseViewModel

@SuppressLint("CheckResult")
class MyViewModel(
    private val remoteRepository: RemoteRepository
) : BaseViewModel() {

    private val TAG = "MyViewModel"

    private val _personData = MutableLiveData<List<Person>>()
    val personData: LiveData<List<Person>>
        get() = _personData

    fun search(argument1: String, argument2: String) {
        remoteRepository.search(argument1, argument2).subscribe({
            when (it) {
                is Result.Success -> _personData.value = it.data!!
                is Result.Failure -> callServerError()
            }
        }, {
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