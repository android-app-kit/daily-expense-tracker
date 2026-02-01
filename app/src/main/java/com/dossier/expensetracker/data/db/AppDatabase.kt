package com.dossier.expensetracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dossier.expensetracker.data.db.dao.ExpenseDao
import com.dossier.expensetracker.data.db.entity.ExpenseEntity

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}