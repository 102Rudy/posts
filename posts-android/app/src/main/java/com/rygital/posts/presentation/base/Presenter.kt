package com.rygital.posts.presentation.base

import androidx.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

interface Presenter<View> {
    fun onAttach(view: View)
    fun onDetach()
}

