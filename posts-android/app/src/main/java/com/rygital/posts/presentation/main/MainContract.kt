package com.rygital.posts.presentation.main

import com.rygital.posts.presentation.base.Presenter

interface MainView {
    fun setItems(items: List<PostViewData>)
    fun showError(localizedError: String)
}

interface MainPresenter : Presenter<MainView>
