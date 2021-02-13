package com.example.mvvm_template.viewModel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_template.util.Event
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {
    protected val _error = MediatorLiveData<Event<String>>()
    val error: LiveData<Event<String>>
        get() = _error

    private val disposable = CompositeDisposable()

    operator fun invoke(disposable: Disposable) {
        this.disposable.add(disposable)
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }


}
