package com.example.mvvm_template.view.di

import com.example.mvvm_template.model.api.MyAPIService
import com.example.mvvm_template.repository.RemoteRepository
import com.example.mvvm_template.viewModel.MyViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT: Long = 15
private const val WRITE_TIMEOUT: Long = 15
private const val READ_TIMEOUT: Long = 15

val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val client = OkHttpClient.Builder().apply {
    addInterceptor(httpLoggingInterceptor)
    connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
    writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
    readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
}.build()

val retrofit: Retrofit = Retrofit
    .Builder()
    .baseUrl("https://www.naver.com/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

private val myApi: MyAPIService = retrofit.create(MyAPIService::class.java)

var retrofitPart = module {
    single{myApi }
}

val remoteRepository = module {
    factory { RemoteRepository(get()) }
}

val viewModelModule = module {
    viewModel { MyViewModel(get())}
}

var myDiModule = listOf(viewModelModule,  remoteRepository, retrofitPart)