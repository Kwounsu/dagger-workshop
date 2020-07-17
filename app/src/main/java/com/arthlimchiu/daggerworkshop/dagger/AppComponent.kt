package com.arthlimchiu.daggerworkshop.dagger

import com.arthlimchiu.daggerworkshop.repos.ReposActivity
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun userDetailsSubcomponent(): UserDetailsSubcomponent.Builder
    fun reposSubcomponent(): ReposSubcomponent.Builder
}