package com.dossier.expensetracker.di

import com.dossier.expensetracker.data.storage.LocalStorageImpl
import com.dossier.expensetracker.domain.repository.LocalStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalStorageBindingModule {

    @Binds
    @Singleton
    abstract fun bindLocalStorage(
        localStorageImpl: LocalStorageImpl
    ): LocalStorage
}