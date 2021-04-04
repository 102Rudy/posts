package com.rygital.posts.domain

import kotlinx.coroutines.flow.Flow

interface PostsInteractor {
    fun getPosts(): Flow<Data<List<PostEntity>>>
}
