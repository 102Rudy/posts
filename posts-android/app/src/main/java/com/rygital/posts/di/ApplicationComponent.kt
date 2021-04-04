package com.rygital.posts.di

import com.rygital.posts.data.PostsRepositoryImpl
import com.rygital.posts.data.PostsService
import com.rygital.posts.data.ServiceFactory
import com.rygital.posts.data.ServiceFactoryImpl
import com.rygital.posts.data.createService
import com.rygital.posts.domain.PostsInteractor
import com.rygital.posts.domain.PostsInteractorImpl
import com.rygital.posts.domain.PostsRepository
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [
        ApplicationBindsModule::class,
        ApplicationProvidesModule::class,
    ]
)
interface ApplicationComponent {
    fun getPostsInteractor(): PostsInteractor
}

@Module
interface ApplicationBindsModule {

    @Binds
    fun bindServiceFactory(impl: ServiceFactoryImpl): ServiceFactory

    @Binds
    fun bindPostsRepository(impl: PostsRepositoryImpl): PostsRepository

    @Binds
    fun bindPostsInteractor(impl: PostsInteractorImpl): PostsInteractor
}

@Module
object ApplicationProvidesModule {

    @Provides
    fun providePostsService(serviceFactory: ServiceFactory): PostsService =
        serviceFactory.createService()
}
