package com.ibrahimengin.newspaper.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ibrahimengin.newspaper.R
import com.ibrahimengin.newspaper.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.detailFragment = this

        val receivedArticle = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(receivedArticle.url)
        }
        binding.detailToolBarTitle = receivedArticle.title

        return binding.root
    }
}