package com.rygital.posts.presentation.base

import androidx.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren

abstract class BasePresenterImpl<View> : Presenter<View> {

    private val presenterJob = Job()
    protected val presenterScope = CoroutineScope(Dispatchers.Main + presenterJob)

    protected var view: View? = null

    @CallSuper
    override fun onAttach(view: View) {
        this.view = view
    }

    @CallSuper
    override fun onDetach() {
        presenterJob.cancelChildren()
        view = null
    }
}
