package com.alura.listfilme.data

class MovieRepository(private val movieDataSource: MovieDataSource) {
        fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
}