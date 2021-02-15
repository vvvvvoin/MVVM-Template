package com.example.mvvm_template.viewModel.mapper

import com.example.mvvm_template.model.dataModel.Result

abstract class NetworkBaseMapper<R> {
    fun map(data: retrofit2.Response<R>): Result<R> {
        return if (data.isSuccessful) {
            data.body()?.let {
                mapTo(it)
            } ?: run {
                Result.Failure("server")
            }
        } else {
            Result.Failure("network")
        }
    }

    abstract fun mapTo(data: R): Result<R>
}