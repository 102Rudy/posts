package com.rygital.posts.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rygital.posts.R

interface OnPostClickListener {
    fun onPostClick(viewData: PostViewData)
}

class MainAdapter(private val onPostClickListener: OnPostClickListener) : RecyclerView.Adapter<PostHolder>() {

    private var items: List<PostViewData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_post, parent, false)
        return PostHolder(view, onPostClickListener)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<PostViewData>) {
        this.items = items
    }
}

data class PostViewData(
    val id: String,
    val title: String,
)

class PostHolder(itemView: View, listener: OnPostClickListener) : RecyclerView.ViewHolder(itemView) {

    private var viewData: PostViewData? = null

    private val tvPostTitle: TextView = itemView.findViewById(R.id.holder_post_title)

    init {
        tvPostTitle.setOnClickListener {
            val nonNullViewData = viewData ?: return@setOnClickListener
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onPostClick(nonNullViewData)
            }
        }
    }

    fun bind(viewData: PostViewData) {
        this.viewData = viewData

        tvPostTitle.text = viewData.title
    }
}
