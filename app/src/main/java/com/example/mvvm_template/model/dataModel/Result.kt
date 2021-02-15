package com.example.mvvm_template.model.dataModel

sealed class Result<out R > {
    class Success<out T >(val data: T) : Result<T>()
    class Failure(val exception: String) : Result<Nothing>()
}