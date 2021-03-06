package com.arthlimchiu.daggerworkshop.dagger

import com.arthlimchiu.daggerworkshop.repos.ReposActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ReposModule::class])
interface ReposSubcomponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ReposSubcomponent
    }

    fun inject(activity: ReposActivity)
}