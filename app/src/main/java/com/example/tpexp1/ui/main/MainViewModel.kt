package com.example.tpexp1.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.data.model.RingtonesResponse
import com.example.tpexp1.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var liveData : MutableLiveData<RingtonesResponse> = MutableLiveData()

    suspend fun getData(): MutableLiveData<RingtonesResponse> {
        return repository.getApiWithLiveData()

    }

}