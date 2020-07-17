package com.arthlimchiu.daggerworkshop.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun userDetailsSubcomponent(): UserDetailsSubcomponent.Builder

    fun reposSubcomponent(): ReposSubcomponent.Builder
}