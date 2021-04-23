package com.alura.listfilme.inplementations

import android.util.Log
import com.alura.listfilme.framework.api.MovieRestApi
import com.alura.listfilme.data.MovieDataSource
import com.alura.listfilme.domain.Movie

class MovieDataSourceImplementation(private val movieRestApi: MovieRestApi):MovieDataSource {
    companion object{
        const val TAG = "MovieRepository"
    }
    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
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