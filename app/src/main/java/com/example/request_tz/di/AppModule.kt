package com.example.request_tz.di

import com.example.request_tz.data.repository.ApiRepositoryImpl
import com.example.request_tz.domain.repository.ApiRepository
import com.example.request_tz.domain.usecases.GetCategoriesUseCase
import com.example.request_tz.domain.usecases.GetProductsUseCase
import com.example.request_tz.domain.usecases.GetTagsUseCase
import com.example.request_tz.domain.usecases.RequestAppUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiRepositoryImpl(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository{
        return apiRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideRequestAppUseCases(repository: ApiRepository): RequestAppUseCases {
        return RequestAppUseCases(
            getCategoriesUseCase = GetCategoriesUseCase(repository),
            getTagsUseCase = GetTagsUseCase(repository),
            getProductsUseCase = GetProductsUseCase(repository)
        )
    }
}