package com.alura.listfilme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alura.listoffilms.R
import com.alura.listfilme.view.model.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var moviesListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesListViewModel= ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        moviesListViewModel.init()
        initObserver()
    }
    private fun initObserver(){
        moviesListViewModel.moviesList.observe(this,  { list ->
            populateList(list)

        })
    }
    private fun populateList(list : List<Movie>){
        movie_list.apply{
            hasFixedSize()
            adapter = MovieAdapter(list)
        }
    }
}