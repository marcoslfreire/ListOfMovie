package com.alura.listfilme.view.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alura.listfilme.domain.Movie
import com.alura.listfilme.framework.api.MovieRestApi
import com.alura.listfilme.data.MovieRepository
import com.alura.listfilme.inplementations.MovieDataSourceImplementation
import com.alura.listfilme.usecase.MovieListUseCase
import kotlin.concurrent.thread


// Class Consulta a Api
class MovieListViewModel: ViewModel() {
    companion object{
        const val TAG = "MovieRepository"
    }
    private val movieRestApi = MovieRestApi()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApi)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MovieListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init() {
        getAllMovies()
    }
        private fun getAllMovies(){
            thread {
                try {
                    _moviesList.postValue(moviesListUseCase.invoke())
                }catch (exception: Exception){
                    Log.d(TAG, exception.message.toString())
                }
            }.start()

     }
}





