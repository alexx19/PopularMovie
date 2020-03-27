package com.aurriola.movietop.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MovieClient {
    val BASE_URL = "https://api.themoviedb.org/3/"
    val gitHubService: IMovieService

    init {
        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //configuracion para okHttp
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loginInterceptor)

            .readTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()

        //configuracion para rotrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)

            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        gitHubService = retrofit.create(IMovieService::class.java)
    }

    fun  getGitHubServices(): IMovieService = gitHubService
}