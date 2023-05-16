package com.ibrahimengin.newspaper.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ibrahimengin.newspaper.R
import com.ibrahimengin.newspaper.databinding.FragmentMainPageBinding
import com.ibrahimengin.newspaper.ui.adapters.NewsAdapter
import com.ibrahimengin.newspaper.ui.viewmodel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    private val viewModel: MainPageViewModel by viewModels()
    private val adapter: NewsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        binding.mainPageFragment = this
        binding.mainPageToolBarTitle = "News"
        binding.newsAdapter = adapter

        viewModel.newsList.observe(viewLifecycleOwner){
            adapter.submitList(it)

        }

        return binding.root
    }


}