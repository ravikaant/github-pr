package com.example.prviewer.network

import com.example.prviewer.utils.constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {

    companion object{

        fun getInstance () : ApiService {
            return Retrofit.Builder()
                .baseUrl(constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java);
        }
    }
}