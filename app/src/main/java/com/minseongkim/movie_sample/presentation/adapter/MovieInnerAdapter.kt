package com.minseongkim.movie_sample.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.minseongkim.movie_sample.databinding.ItemMovieNumberBinding
import com.minseongkim.movie_sample.databinding.ItemMoviePosterBinding
import com.minseongkim.movie_sample.presentation.model.LayoutStyle
import com.minseongkim.movie_sample.presentation.model.Movie

class MovieInnerAdapter(private val movie: List<Movie>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            LayoutStyle.TOP.value -> {
                TopHolder(ItemMovieNumberBinding.inflate(inflater, parent, false))
            }
            else -> {
                DefaultHolder(ItemMoviePosterBinding.inflate(inflater, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = movie[position]
        when (data.layoutType) {
            LayoutStyle.TOP -> {
                (holder as TopHolder).bind(movie[position])
            }
            else -> {
                (holder as DefaultHolder).bind(movie[position])
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return movie[position].layoutType.value
    }

    override fun getItemCount(): Int =
        movie.size

    class DefaultHolder(private val binding: ItemMoviePosterBinding) :
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

    class TopHolder(private val binding: ItemMovieNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieData: Movie) {
            val ranked = adapterPosition + 1
            binding.apply {
                movieNumber.text = ranked.toString()
                movieNumber.modifyLetterSpacing(ranked)
                movie = movieData
                executePendingBindings()
            }
            itemView.setOnClickListener {

            }
        }

        private fun navigateToDetail(movie: Movie, view: View) {
            // TODO Navigate to detail fragment use navController.
        }

        /**
         * Extension function for TextView letter spacing.
         * because textview has inner default padding.
         *
         * @param ranked movie position
         */
        private fun AppCompatTextView.modifyLetterSpacing(ranked: Int) {
            when (ranked) {
                1 -> this.letterSpacing = -0.2f
                10 -> this.letterSpacing = -0.3f
                else -> this.letterSpacing = -0.1f
            }
        }
    }
}