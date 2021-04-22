package com.alura.listfilme.data

import com.alura.listfilme.domain.Movie

interface MovieDataSource {
    fun getAllMovies(): List<Movie>
}