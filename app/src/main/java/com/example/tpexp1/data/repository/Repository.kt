package com.example.tpexp1.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tpexp1.data.model.RingtonesResponse

interface Repository {

    suspend fun getApiWithLiveData(): MutableLiveData<RingtonesResponse>
}