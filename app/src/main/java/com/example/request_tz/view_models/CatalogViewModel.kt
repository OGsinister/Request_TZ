package com.example.request_tz.view_models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.model.Tags
import com.example.request_tz.domain.usecases.GetCategoriesUseCase
import com.example.request_tz.domain.usecases.GetProductsUseCase
import com.example.request_tz.domain.usecases.GetTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getCategories: GetCategoriesUseCase,
    private val getProducts: GetProductsUseCase,
    private val getTags: GetTagsUseCase
): ViewModel() {
    private val _categories = mutableStateOf(listOf(Categories()))
    var categories = _categories

    private val _products = mutableStateOf(listOf(Products()))
    var products = _products

    private val _tags = mutableStateOf(listOf(Tags()))
    var tags = _tags

    fun getCategories(){
        _categories.value = getCategories.invoke()
    }
    fun getProducts(){
        _products.value = getProducts.invoke()
    }
    fun getTags(){
        _tags.value = getTags.invoke()
    }
}