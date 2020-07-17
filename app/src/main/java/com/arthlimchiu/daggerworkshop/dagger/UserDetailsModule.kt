package com.arthlimchiu.daggerworkshop.dagger

import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.userdetails.UserRepository
import com.arthlimchiu.daggerworkshop.userdetails.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class UserDetailsModule {
    @Provides
    @ActivityScope
    fun providesUserRepository(api: Api): UserRepository {
        return UserRepositoryImpl(api)
    }
}