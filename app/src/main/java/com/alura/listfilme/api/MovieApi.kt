package com.alura.listfilme.api

import com.alura.listfilme.Movie
import retrofit2.http.GET

interface MovieApi {
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovie(): List<Movie>
}