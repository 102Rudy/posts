package com.rygital.posts.data

import retrofit2.http.GET

interface PostsService {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
