package com.example.tpexp1.data.model

import com.google.gson.annotations.SerializedName

class Status {
    @SerializedName("message")
    var message: String? = null

    @SerializedName("statusCode")
    var statusCode: Long? = null
}