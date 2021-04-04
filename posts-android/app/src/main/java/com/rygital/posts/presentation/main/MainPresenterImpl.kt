package com.rygital.posts.presentation.main

import com.rygital.posts.domain.Data
import com.rygital.posts.domain.PostEntity
import com.rygital.posts.domain.PostsInteractor
import com.rygital.posts.domain.mapData
import com.rygital.posts.presentation.base.BasePresenterImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val postsInteractor: PostsInteractor
) : BasePresenterImpl<MainView>(), MainPresenter {

    override fun onAttach(view: MainView) {
        super.onAttach(view)

        postsInteractor.getPosts()
            .mapData { mapPostsToViewData(it) }
            .flowOn(Dispatchers.IO)
            .onEach { postsData ->
                when (postsData) {
                    is Data.Content -> view.setItems(postsData.content)
                    is Data.Error -> view.showError(postsData.throwable.localizedMessage ?: "Something went wrong")
                    is Data.Loading -> Unit // just do nothing for now
                }
            }
            .launchIn(presenterScope)
    }

    private fun mapPostsToViewData(posts: List<PostEntity>): List<PostViewData> =
        posts.map { PostViewData(it.id, it.title) }
}
