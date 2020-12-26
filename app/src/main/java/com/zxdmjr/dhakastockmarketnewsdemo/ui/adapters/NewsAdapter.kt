package com.zxdmjr.dhakastockmarketnewsdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.ticonsys.baseadapter.BaseAdapter
import com.zxdmjr.dhakastockmarketnewsdemo.data.domain.model.News
import com.zxdmjr.dhakastockmarketnewsdemo.databinding.SimpleNewsItemBinding
import javax.inject.Inject

class NewsAdapter @Inject constructor(
) : BaseAdapter<News, SimpleNewsItemBinding>() {
    override fun initializeDiffItemCallback() = object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(
            oldItem: News, newItem: News
        ) = oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: News, newItem: News
        ) = oldItem == newItem

    }

    override fun initializeViewBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ) = SimpleNewsItemBinding.inflate(layoutInflater, parent, false)

    override fun onBindViewHolder(holder: BaseViewHolder<SimpleNewsItemBinding>, position: Int) {
        val news = differ.currentList[position]
        holder.binding.apply {
            tvScrip.text = news.scrip
            tvTitle.text = news.title
            tvDate.text = news.publishDate
            tvDescription.text = news.content
        }
    }
}