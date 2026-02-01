package com.dossier.expensetracker.di

import com.dossier.expensetracker.data.repository.ExpenseRepositoryImpl
import com.dossier.expensetracker.domain.repository.ExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindItemRepository(
        itemRepositoryImpl: ExpenseRepositoryImpl
    ): ExpenseRepository
}