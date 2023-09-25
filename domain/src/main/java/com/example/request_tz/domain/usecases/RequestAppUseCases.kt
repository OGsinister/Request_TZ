package com.example.request_tz.domain.usecases

data class RequestAppUseCases(
    val getCategoriesUseCase: GetCategoriesUseCase,
    val getTagsUseCase: GetTagsUseCase,
    val getProductByTagsUseCase: GetProductsByTagsUseCase,
    val getAllProductsUseCase: GetAllProductsUseCase
)
