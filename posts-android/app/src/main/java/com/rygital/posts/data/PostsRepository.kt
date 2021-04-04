package com.rygital.posts.data

import com.rygital.posts.domain.Data
import com.rygital.posts.domain.PostEntity
import com.rygital.posts.domain.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsService: PostsService
) : PostsRepository {

    override fun getPosts(): Flow<Data<List<PostEntity>>> =
        flow { emit(postsService.getPosts()) }
            .map { posts -> posts.map { it.toDomain() } }
            .map { Data.content(it) }
            .onStart { emit(Data.loading()) }
            .catch { emit(Data.error(it)) }
}

private fun PostDto.toDomain(): PostEntity =
    PostEntity(this.id, this.title)
