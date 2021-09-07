package com.example.showrandomimage.Network

import javax.inject.Inject

class ApiHelper @Inject constructor(val apiService: ApiService) {
    suspend fun getRandomImage() = apiService.getRandomImage()
}