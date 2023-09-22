package com.example.request_tz.domain.usecases

import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.repository.ApiRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ApiRepository
) {
    operator fun invoke(categoryId: Int): List<Products> {
        return repository.getProducts(categoryId)
    }
}