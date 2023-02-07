package com.example.tpexp1.data.model

import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("currentPageNumber")
    var currentPageNumber: Long? = null

    @SerializedName("nextPageNumber")
    var nextPageNumber: Long? = null

    @SerializedName("pageSize")
    var pageSize: Long? = null

    @SerializedName("ringtones")
    var ringtones: ArrayList<Ringtone>? = null
}