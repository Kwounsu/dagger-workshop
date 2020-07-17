package com.arthlimchiu.daggerworkshop.dagger

import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [UserDetailsModule::class])
interface UserDetailsSubcomponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserDetailsSubcomponent
    }

    fun inject(activity: UserDetailsActivity)
}