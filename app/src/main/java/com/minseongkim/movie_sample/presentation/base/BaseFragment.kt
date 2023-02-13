package com.minseongkim.movie_sample.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.minseongkim.movie_sample.presentation.viewmodel.MovieViewModel

/**
 * [BaseFragment] is just example for base fragment
 *
 * @param layoutRes Layout id(R.layout.fragment_example)
 */
abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
) : Fragment() {

    protected lateinit var binding: T
        private set
    protected val sharedViewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

    /**
     * binding builder
     */
    protected inline fun bind(block: T.() -> Unit) {
        binding.apply(block)
    }
}