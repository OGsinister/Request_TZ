package com.example.request_tz.domain.usecases

import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.repository.ApiRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: ApiRepository
) {
    operator fun invoke(): List<Categories> {
        return repository.getCategories()
    }
}