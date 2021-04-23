package com.alura.listfilme.usecase

import com.alura.listfilme.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()
}