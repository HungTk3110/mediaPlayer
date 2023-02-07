package com.example.tpexp1.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Ringtone(
    @SerializedName("avgTrend")
    var avgTrend: Any? = null,

    @SerializedName("category")
    var category: String? = null,

    @SerializedName("displayHashtag")
    var displayHashtag: String? = null,

    @SerializedName("down")
    var down: Any? = null,

    @SerializedName("duration")
    var duration: Long? = null,

    @SerializedName("endColorCode")
    var endColorCode: String? = null,

    @SerializedName("firstHashtag")
    var firstHashtag: Any? = null,

    @SerializedName("hashTag")
    var hashTag: String? = null,

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("screenRatio")
    var screenRatio: Any? = null,

    @SerializedName("secondHashtag")
    var secondHashtag: Any? = null,

    @SerializedName("startColorCode")
    var startColorCode: String? = null,

    @SerializedName("thirdHashtag")
    var thirdHashtag: Any? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("collection")
    var collection: Collection = Collection(),

    @SerializedName("url")
    var url: String? = null

) : Serializable