package com.alura.listfilme.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApi {
    //fAÇAS A INTANCIA DE UM OBJETO DE RETROFIT QUE IRA RETORNA A CONSULTA AO WEB.
    companion object{
        const val BASE_URL = ("https://raw.githubusercontent.com/")
    }
    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi (): MovieApi = movieProvider().create(MovieApi::class.java)
}