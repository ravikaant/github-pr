package com.example.prviewer.network

import com.example.prviewer.model.PRModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/repos/torvalds/linux/pulls")
    suspend fun getPullRequests(@Query("state") state : String) : Response<List<PRModel>>

}