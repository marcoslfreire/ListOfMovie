package com.alura.listfilme.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alura.listfilme.domain.Movie
import com.alura.listoffilms.R
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MovieAdapter(val moviesList: List<Movie>) : RecyclerView.Adapter<MoviesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            movie_title.text = moviesList[position].titulo
            movie_image.load(moviesList[position].image){
                placeholder(R.drawable.ic_android_black_24dp)
                fallback(R.drawable.ic_android_black_24dp)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size

}