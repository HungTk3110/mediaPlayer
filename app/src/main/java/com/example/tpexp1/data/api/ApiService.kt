package com.example.tpexp1.data.api

import com.example.tpexp1.data.model.RingtonesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("ringtones")
    fun getDataFromApi(
        @Header("X-NetworkType") NetworkType: String ? = "",
        @Header("language") language: String ?= "",
        @Header("country") country: String ?= "",
        @Query("pageNumber") pageNumber: Int ?= 0
    ): Call<RingtonesResponse>
}