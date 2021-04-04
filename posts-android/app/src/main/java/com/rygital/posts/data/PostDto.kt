package com.rygital.posts.data

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
)
