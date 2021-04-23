package com.alura.listfilme.api

import com.alura.listfilme.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    //Chamada para API LISTA DE FILMES
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>
}