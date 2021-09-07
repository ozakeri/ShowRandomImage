package com.example.showrandomimage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.showrandomimage.Network.ApiHelper
import com.example.showrandomimage.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val apiHelper: ApiHelper) : ViewModel() {

    fun getRandomImage() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiHelper.getRandomImage()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message))
        }
    }
}