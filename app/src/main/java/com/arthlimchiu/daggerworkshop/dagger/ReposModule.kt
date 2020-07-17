package com.arthlimchiu.daggerworkshop.dagger

import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.repos.ReposRepository
import com.arthlimchiu.daggerworkshop.repos.ReposRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ReposModule {
    @Provides
    @ActivityScope
    fun providesReposRepository(api: Api): ReposRepository {
        return ReposRepositoryImpl(api)
    }
}