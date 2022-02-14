package com.yedirapp.yedir.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


class AppPref(var context: Context) {
    companion object {
        val Context.ds : DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("onBoard")

        val ONBOARD_KEY = booleanPreferencesKey("ONBOARD")
    }
    suspend fun setPref(result:Boolean){
        context.ds.edit {
            it[ONBOARD_KEY] = result
        }
    }
    suspend fun getPref():Boolean{
        val p = context.ds.data.first()
        Log.e("pref2","${p[ONBOARD_KEY]}")
        return p[ONBOARD_KEY] ?: false
    }

}
