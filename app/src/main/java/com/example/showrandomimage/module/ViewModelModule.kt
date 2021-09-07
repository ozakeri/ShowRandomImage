package com.example.showrandomimage.module

import com.example.showrandomimage.Network.ApiHelper
import com.example.showrandomimage.Network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun viewModelProvider(apiService: ApiService): ApiHelper {
        return ApiHelper(apiService)
    }
}