package com.example.request_tz.domain.usecases

import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.repository.ApiRepository
import javax.inject.Inject

class GetProductsByTagsUseCase @Inject constructor(
    private val repository: ApiRepository
) {
    operator fun invoke(listId: List<Int>, categoryId: Int): List<Products> {
        return repository.getProductByTags(listId, categoryId)
    }
}