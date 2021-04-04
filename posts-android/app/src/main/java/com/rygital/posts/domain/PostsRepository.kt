package com.rygital.posts.domain

import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<Data<List<PostEntity>>>
}
