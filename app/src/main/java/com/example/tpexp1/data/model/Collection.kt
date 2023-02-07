package com.example.tpexp1.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Collection(
    @SerializedName("collection")
    var collection: String? = null,

    @SerializedName("collectionType")
    var collectionType: String? = null,

    @SerializedName("createdDate")
    var createdDate: Any? = null,

    @SerializedName("description")
    var description: Any? = null,

    @SerializedName("descriptionByLang")
    var descriptionByLang: Any? = null,

    @SerializedName("detailImage")
    var detailImage: String? = null,

    @SerializedName("displayByLang")
    var displayByLang: String? = null,

    @SerializedName("id")
    var id: Long? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("isMin")
    var isMin: String? = null,

    @SerializedName("isShow")
    var isShow: String? = null,

    @SerializedName("listImage")
    var listImage: String? = null,

    @SerializedName("minByCountry")
    var minByCountry: Any? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("screen")
    var screen: Any? = null,

    @SerializedName("type")
    var type: String? = null,
) : Serializable