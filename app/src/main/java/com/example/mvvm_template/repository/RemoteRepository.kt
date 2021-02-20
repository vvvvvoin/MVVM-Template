package com.example.mvvm_template.repository

import com.example.mvvm_template.model.api.MyAPIService
import com.example.mvvm_template.model.dataModel.Person
import com.example.mvvm_template.model.dataModel.Result
import com.example.mvvm_template.viewModel.mapper.PersonMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RemoteRepository(private val myApi: MyAPIService) {
    private val TAG = "RemoteRepository"

    fun search(argument1 : String, argument2 : String): Single<Result<List<Person>>> {
        return myApi.search(argument1, argument2)
            .subscribeOn(Schedulers.io())
            .map(PersonMapper::map)
            .observeOn(AndroidSchedulers.mainThread())
    }

}