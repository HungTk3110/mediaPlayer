package com.example.tpexp1.data.model

import com.google.gson.annotations.SerializedName

class RingtonesResponse {
    @SerializedName("data")
    var data: Data? = null

    @SerializedName("status")
    var status: Status? = null
}