package com.example.prviewer.utils.network

import com.example.prviewer.model.PRModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/repos/{userName}/{repoName}/pulls")
    suspend fun getPullRequests(@Path("userName") userName : String,
                                @Path("repoName") repoName : String,
                                @Query("state") state : String)
    : Response<List<PRModel>>

}