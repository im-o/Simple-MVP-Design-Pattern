package com.stimednp.androidsimplemvp.network

import com.google.gson.GsonBuilder
import com.stimednp.androidsimplemvp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rivaldy on 12/5/2019.
 */

object ApiClient {
    val gson = GsonBuilder().setLenient().create()
    val interceptor = HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    private val tsdbClient = OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .build()

    private fun myretrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(tsdbClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    val iRepository: ApiRepository = myretrofit()
        .create(ApiRepository::class.java)
}