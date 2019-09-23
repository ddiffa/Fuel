package com.example.fuel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fuel.R
import com.example.fuel.room.entity.NewsEntity
import kotlinx.android.synthetic.main.item_article.view.*

class NewsAdapter : ListAdapter<NewsEntity, NewsAdapter.ViewHolder>(NewsItemCallback()) {

    private class NewsItemCallback : DiffUtil.ItemCallback<NewsEntity>() {
        override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean =
            oldItem?.title == newItem?.title

        override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean =
            oldItem?.title == newItem?.title
    }

    fun isLastItemVisible(): Boolean {
        getItem(itemCount - 1)
        return false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_article,
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = getItem(position)
        if (news != null) holder.bind(news)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: NewsEntity?) = with(itemView) {
            tv_judul_artikel.text = news?.title
            tv_tanggal.text = news?.publishedAt
            Glide.with(itemView)
                .load(news?.urlToImage)
                .into(img_artikel)
        }

    }
}