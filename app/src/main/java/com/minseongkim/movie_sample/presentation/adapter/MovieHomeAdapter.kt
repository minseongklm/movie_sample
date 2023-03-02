package com.minseongkim.movie_sample.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minseongkim.movie_sample.databinding.ItemMovieHomeBinding
import com.minseongkim.movie_sample.presentation.model.Movies

class MovieHomeAdapter : ListAdapter<Movies, MovieHomeAdapter.HomeViewHolder>(diffCallback) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(ItemMovieHomeBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class HomeViewHolder(private val binding: ItemMovieHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            binding.apply {
                movieTitle.text = movies.section
                adapter = MovieInnerAdapter(movies.movies)
                executePendingBindings()
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Movies>() {
            override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean =
                oldItem.section == newItem.section

            override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean =
                oldItem == newItem
        }
    }
}