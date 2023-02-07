package com.example.demo.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tpexp1.data.api.ApiService
import com.example.tpexp1.data.model.RingtonesResponse
import com.example.tpexp1.data.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private var apiService: ApiService,
) : Repository {
    override suspend fun getApiWithLiveData(): MutableLiveData<RingtonesResponse> {
        return MutableLiveData<RingtonesResponse>().also { live ->
            val call = apiService.getDataFromApi("medium","us", "US",3)
            call.enqueue(object : Callback<RingtonesResponse> {
                override fun onFailure(call: Call<RingtonesResponse>, t: Throwable) {
                    Log.v("DEBUG : ", t.message.toString())
                }

                override fun onResponse(
                    call: Call<RingtonesResponse>,
                    response: Response<RingtonesResponse>,
                ) {
                    live.value = response.body()
                    Log.v("APIiii", response.body()?.data?.ringtones.toString())
                }
            })
        }
    }
}

