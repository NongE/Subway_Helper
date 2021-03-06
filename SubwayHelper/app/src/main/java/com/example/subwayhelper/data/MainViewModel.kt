package com.example.subwayhelper.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.subwayhelper.data.RealmLiveData
import com.example.subwayhelper.data.realm.LatestDao
import com.example.subwayhelper.data.realm.LatestData
import io.realm.Realm

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }


    private val emoticonDao: LatestDao by lazy {
        LatestDao(realm)
    }

    val latestLiveData: RealmLiveData<LatestData> by lazy {
        RealmLiveData<LatestData>(emoticonDao.getAllRealm())
    }

    override fun onCleared() {
        super.onCleared()
        realm.close()
    }


}