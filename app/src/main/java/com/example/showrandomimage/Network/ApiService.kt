package com.example.showrandomimage.Network

import com.example.showrandomimage.model.Dog
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/breeds/image/random")
    suspend fun getRandomImage(): Response<Dog>
}