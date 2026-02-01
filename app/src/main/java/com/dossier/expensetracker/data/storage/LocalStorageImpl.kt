package com.dossier.expensetracker.data.storage

import android.content.SharedPreferences
import androidx.core.content.edit
import com.dossier.expensetracker.domain.repository.LocalStorage
import javax.inject.Inject

class LocalStorageImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : LocalStorage{

    override fun putLocalData(key: String, value: String) {
        sharedPreferences
            .edit {
                putString(key, value)
            }
    }

    override fun getLocalData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}