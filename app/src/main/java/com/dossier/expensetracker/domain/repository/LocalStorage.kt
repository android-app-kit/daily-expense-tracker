package com.dossier.expensetracker.domain.repository

interface LocalStorage {
    fun putLocalData(key: String, value: String)
    fun getLocalData(key: String): String?
}