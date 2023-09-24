package com.example.request_tz.view_models

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.model.Tags
import com.example.request_tz.domain.usecases.GetCategoriesUseCase
import com.example.request_tz.domain.usecases.GetProductsBySearchUseCase
import com.example.request_tz.domain.usecases.GetProductsUseCase
import com.example.request_tz.domain.usecases.GetTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getCategories: GetCategoriesUseCase,
    private val getTags: GetTagsUseCase,
    private val getProducts: GetProductsUseCase,
    private val getProductsBySearch: GetProductsBySearchUseCase
): ViewModel() {
    private val _categories = mutableStateOf(listOf(Categories()))
    var categories = _categories

    private var _currentCategory = mutableIntStateOf(676153)
    var currentCategory = _currentCategory

    private val _products = mutableStateOf<List<Products>>(emptyList())
    var products = _products

    private val _foundedProducts = MutableStateFlow<List<Products>>(emptyList())
    var foundedProducts = _foundedProducts

    private val _totalSum = mutableIntStateOf(0)
    var totalSum = _totalSum

    private val _order = mutableStateOf<List<Products>>(emptyList())
    var order = _order

    fun addToCart(products: Products){
        _order.value += products
        _totalSum.intValue += products.price_current!!
    }
    fun removeFromCart(products: Products){
        _order.value -= products
        _totalSum.intValue -= products.price_current!!
    }

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

    // Search
    private val _searchText = MutableStateFlow("")
    var searchText = _searchText

    fun onSearchTextChange(text: String){
        _searchText.value = text
        _foundedProducts.value = getProductsBySearch.invoke(text)
    }
}