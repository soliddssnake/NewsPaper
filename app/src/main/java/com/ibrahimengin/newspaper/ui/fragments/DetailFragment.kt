package com.ibrahimengin.newspaper.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ibrahimengin.newspaper.R
import com.ibrahimengin.newspaper.databinding.FragmentDetailBinding
import com.ibrahimengin.newspaper.databinding.FragmentMainPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        binding.detailFragment = this
        return binding.root
    }
}