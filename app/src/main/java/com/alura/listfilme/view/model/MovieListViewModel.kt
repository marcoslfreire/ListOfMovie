package com.alura.listfilme.view.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alura.listfilme.domain.Movie
import com.alura.listfilme.api.MovieRestApi
import com.alura.listfilme.repository.MovieRepository
import kotlin.Exception
import kotlin.concurrent.thread
// Class Consulta a Api
class MovieListViewModel: ViewModel() {
    companion object{
        const val TAG = "MovieRepositoryc"
    }

    private val movieRestApi = MovieRestApi()
    private val movieRepository = MovieRepository(movieRestApi)

    private var _moviesList = MutableLiveData<List<Movie>>()

    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init() {
        getAllMovies()
    }

     private fun getAllMovies() = thread {
         try {
             _moviesList.postValue(movieRepository.getAllMovies())
         }catch (exception: Exception){
             Log.d(TAG, exception.message.toString())
         }
     }.start()
}



