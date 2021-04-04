package com.rygital.posts.di

import androidx.fragment.app.FragmentActivity

val FragmentActivity.applicationComponent: ApplicationComponent
    get() = (application as ApplicationComponentHolder).applicationComponent
