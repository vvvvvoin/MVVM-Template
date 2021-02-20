package com.example.mvvm_template.model.api

import com.example.mvvm_template.model.dataModel.Person
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface MyAPIService {
    @GET("/")
    fun search(
        @Header("Authorization") auth : String,
        @Query("query") query: String,
    ) : Single<Response<List<Person>>>
}