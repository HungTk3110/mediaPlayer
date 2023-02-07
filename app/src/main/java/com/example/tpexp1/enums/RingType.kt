package com.example.tpexp1.enums

enum class RingType (val viewType: Int, val type: String) {
    RING(viewType = 0, type = "ringtone"),
    COLLECTION(viewType = 1, type = "collection"),
    ADVERTISE(viewType = 2, type = "nativeAds"),
    COLLECTION_RECOMMEND(viewType = 3, type = "recommend"),
    COLLECTION_NORMAL(viewType = 4, type = "normal"),
}