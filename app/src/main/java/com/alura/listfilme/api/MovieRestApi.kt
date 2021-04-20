package com.alura.listfilme.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApi {
    companion object{
        const val BASE_URL = ("https://raw.githubusercontent.com/")
    }
    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi (): MovieApi = movieProvider().create(MovieApi::class.java)
}