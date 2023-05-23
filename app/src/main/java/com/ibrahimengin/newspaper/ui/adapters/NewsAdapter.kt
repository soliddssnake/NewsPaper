package com.ibrahimengin.newspaper.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimengin.newspaper.R
import com.ibrahimengin.newspaper.data.entity.Article
import com.ibrahimengin.newspaper.databinding.ItemNewsBinding

class NewsAdapter(private val onArticleClick: (article: Article) -> Unit) :
    ListAdapter<Article, NewsAdapter.CardViewHolder>(ArticleDiffUtil()) {

    inner class CardViewHolder(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ItemNewsBinding

        init {
            this.binding = binding
        }
    }

    class ArticleDiffUtil : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemNewsBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_news, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val article = getItem(position)
        val b = holder.binding
        b.articleObject = article
        Glide.with(b.root).load(article.urlToImage).into(b.imageView)
        b.itemRow.setOnClickListener {
            onArticleClick(article)
        }
    }
}