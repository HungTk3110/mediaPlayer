package com.example.tpexp1.data.realm

import android.content.Context
import com.example.tpexp1.data.model.RealmFavourite
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.delete

class RealmManager(context: Context) {
    private var realm: Realm

    init {
        Realm.init(context)
        val config = RealmConfiguration.Builder()
            .schemaVersion(3)
            .build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()
    }


    fun find(id: Int): Boolean {
        return (realm.where(RealmFavourite::class.java).equalTo("id", id).findFirst() != null)
    }

    fun insert(id: Int, favou: Int) {
        realm.beginTransaction()
        val favourite = realm.createObject(RealmFavourite::class.java)
        favourite.id = id
        favourite.favourite = favou
        realm.commitTransaction()
    }


    fun deleteById(id: Int) {
        realm.beginTransaction()
        val results = realm.where(RealmFavourite::class.java).equalTo("id", id).findAll()
        results.deleteAllFromRealm()
        realm.commitTransaction()
    }
}