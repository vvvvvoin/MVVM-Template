package com.example.mvvm_template.model.api

import com.example.mvvm_template.model.model.Person
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface MyAPIService {
    @GET("/")
    fun search(
        @Header("Authorization") auth : String,
        @Query("query") query: String,
    ) : Single<Response<List<Person>>>
}