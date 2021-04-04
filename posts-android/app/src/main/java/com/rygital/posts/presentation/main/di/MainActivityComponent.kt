package com.rygital.posts.presentation.main.di

import com.rygital.posts.di.ApplicationComponent
import com.rygital.posts.presentation.main.MainActivity
import com.rygital.posts.presentation.main.MainAdapter
import com.rygital.posts.presentation.main.MainPresenter
import com.rygital.posts.presentation.main.MainPresenterImpl
import com.rygital.posts.di.applicationComponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [
        MainActivityBindsModule::class,
        MainActivityProvidesModule::class,
    ],
    dependencies = [
        ApplicationComponent::class
    ]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: MainActivity,
            applicationComponent: ApplicationComponent,
        ): MainActivityComponent
    }

    companion object {
        fun create(
            activity: MainActivity,
        ): MainActivityComponent =
            DaggerMainActivityComponent.factory().create(
                activity,
                activity.applicationComponent,
            )
    }
}

@Module
interface MainActivityBindsModule {
    @Binds
    fun bindPresenter(impl: MainPresenterImpl): MainPresenter
}

@Module
object MainActivityProvidesModule {

    @Provides
    fun provideAdapter(activity: MainActivity): MainAdapter = MainAdapter(activity)
}
