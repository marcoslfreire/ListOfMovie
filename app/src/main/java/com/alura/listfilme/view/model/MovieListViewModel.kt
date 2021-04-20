package com.alura.listfilme.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alura.listfilme.Movie
import com.alura.listfilme.api.MovieRestApi

class MovieListViewModel: ViewModel() {
    private val movieRestApi = MovieRestApi()
    private val listOfMovie = arrayListOf(
        Movie(
            id = 0,
            titulo = "Titanic",
            descricao = null,
            image = null,
            datalancamento = null

            ),
        Movie(
            id = 1,
            titulo = "Cabra da Pest",
            descricao = null,
            image = null,
            datalancamento = null

            ),
        Movie(
            id = 3,
            titulo = "America",
            descricao = null,
            image = null,
            datalancamento = null

            ),
    )
    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
    get() = _moviesList
    fun init() {
        getAllMovies()
    }

    private fun getAllMovies(){
        _moviesList.value = listOfMovie
    }}

