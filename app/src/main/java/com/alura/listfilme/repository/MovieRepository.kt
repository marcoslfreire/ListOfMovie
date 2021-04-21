package com.alura.listfilme.repository

import android.util.Log
import com.alura.listfilme.Movie
import com.alura.listfilme.api.MovieRestApi

class MovieRepository(private val movieRestApi: MovieRestApi){
    companion object{
        const val TAG = "MovieRepository"
    }
    private val movieList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie>{

        val request = movieRestApi.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }
        }else{
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }
}