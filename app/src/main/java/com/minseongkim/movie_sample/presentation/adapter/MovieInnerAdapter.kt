package com.minseongkim.movie_sample.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minseongkim.movie_sample.databinding.ItemMoviePosterBinding
import com.minseongkim.movie_sample.presentation.model.Movie

class MovieInnerAdapter(private val movie: List<Movie>) :
    RecyclerView.Adapter<MovieInnerAdapter.InnerViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): InnerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return InnerViewHolder(ItemMoviePosterBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.bind(movie[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int =
        movie.size

    class InnerViewHolder(private val binding: ItemMoviePosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieData: Movie) {
            binding.apply {
                movie = movieData
                executePendingBindings()
            }
            itemView.setOnClickListener {
                Log.d("TAG", "bind: ${movieData.id}")
            }
        }

        private fun navigateToDetail(movie: Movie, view: View) {
            // TODO Navigate to detail fragment use navController.
        }
    }
}