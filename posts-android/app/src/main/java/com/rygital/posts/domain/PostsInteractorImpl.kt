package com.rygital.posts.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsInteractorImpl @Inject constructor(
    private val postsRepository: PostsRepository
) : PostsInteractor {

    override fun getPosts(): Flow<Data<List<PostEntity>>> = postsRepository.getPosts()
}
