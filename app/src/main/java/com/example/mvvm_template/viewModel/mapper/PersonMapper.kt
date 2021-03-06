package com.example.mvvm_template.viewModel.mapper

import com.example.mvvm_template.model.dataModel.Person
import com.example.mvvm_template.model.dataModel.Result

object PersonMapper : NetworkBaseMapper< List<Person>>() {
    override fun mapTo(data:  List<Person>): Result<List<Person>> {
        return if (data != null) {
            Result.Success(data)
        } else
            Result.Failure("server")
    }
}