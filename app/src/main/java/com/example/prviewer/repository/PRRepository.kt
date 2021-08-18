package com.example.prviewer.repository

import com.example.prviewer.model.PRModel
import com.example.prviewer.utils.network.ApiService
import retrofit2.Response

class PRRepository (
    private val apiService: ApiService,
    private val state : String
    )
{
    suspend fun getPullRequests() : List<PRModel>? {
        val response : Response<List<PRModel>> = apiService.getPullRequests(state)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

}