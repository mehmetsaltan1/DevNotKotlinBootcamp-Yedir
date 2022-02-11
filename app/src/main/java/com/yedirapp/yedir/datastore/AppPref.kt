package com.yedirapp.yedir.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {
    val Context.dataStore : DataStore<Preferences> by preferencesDataStore("newOnboard")
    companion object {
        val ONBOARD_KEY = booleanPreferencesKey("newOnBoard")
    }
    suspend fun setPref(result:Boolean){
        context.dataStore.edit {
            it[ONBOARD_KEY] = result
        }
    }
    suspend fun getPref():Boolean{
        val p = context.dataStore.data.first()
        Log.e("pref2","${p[ONBOARD_KEY]}")
        return p[ONBOARD_KEY] ?:false
    }

}