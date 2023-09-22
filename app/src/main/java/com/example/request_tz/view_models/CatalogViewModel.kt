package com.example.request_tz.view_models

import androidx.compose.runtime.mutableIntStateOf
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
    private val getTags: GetTagsUseCase,
    private val getProducts: GetProductsUseCase
): ViewModel() {
    var isCartVisible = mutableStateOf(false)
    val buyCounter = mutableIntStateOf(0)

    private val _categories = mutableStateOf(listOf(Categories()))
    var categories = _categories

    private var _currentCategory = mutableIntStateOf(676153)
    var currentCategory = _currentCategory

    private val _products = mutableStateOf(listOf(Products()))
    var products = _products

    private val _tags = mutableStateOf(listOf(Tags()))
    var tags = _tags

    // must make "on event" func
    fun getTags(){
        _tags.value = getTags.invoke()
    }
    fun changeCategory(newCategory: Int){
        _currentCategory.intValue = newCategory
    }
    fun getCategories(){
        _categories.value = getCategories.invoke()
    }
    fun getProducts(){
        _products.value = getProducts.invoke(currentCategory.intValue)
    }
}