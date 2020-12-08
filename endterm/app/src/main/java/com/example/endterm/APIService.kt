package com.example.endterm

import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @GET("posts/")
    fun getPosts(): Call<MutableList<Posts>>

    @GET("posts/{title}/")
    fun getTaskById(@Path("title") postTitle: String): Call<Posts>

    @FormUrlEncoded
    @POST("posts")
    fun addTask(
        @Field("title") title: String,
        @Field("body") body: String
    ): Call<Posts>

    @FormUrlEncoded
    @PUT("posts/{id}/")
    fun updateTask(
        @Path("id") taskId: Int,
        @Field("completed") completed: Boolean
    ): Call<Posts>

    @GET("users/{id}/")
    fun getUser(@Path("id") userId: Int): Call<Posts>
}