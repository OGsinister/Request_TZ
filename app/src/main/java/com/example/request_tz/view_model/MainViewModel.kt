package com.example.request_tz.view_model

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.model.Tags
import com.example.request_tz.domain.usecases.GetAllProductsUseCase
import com.example.request_tz.domain.usecases.GetCategoriesUseCase
import com.example.request_tz.domain.usecases.GetProductsByTagsUseCase
import com.example.request_tz.domain.usecases.GetTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategories: GetCategoriesUseCase,
    private val getTags: GetTagsUseCase,
    private val getProductsByTags: GetProductsByTagsUseCase,
    private val getAllProducts: GetAllProductsUseCase
): ViewModel() {

    private val _categories = mutableStateOf(listOf(Categories()))
    var categories = _categories

    private var _currentCategory = mutableIntStateOf(676153)
    var currentCategory = _currentCategory

    private val _products = mutableStateOf<List<Products>>(emptyList())
    var products = _products

    private val _allProducts = mutableStateOf<List<Products>>(emptyList())
    var allProducts = _allProducts

    private val _foundedProducts = MutableStateFlow<List<Products>>(emptyList())
    var foundedProducts = _foundedProducts

    private val _totalPrice = mutableIntStateOf(0)
    var totalPrice = _totalPrice

    private val _order = mutableStateOf<List<Products>>(emptyList())
    var order = _order

    private val _tags = mutableStateOf(listOf(Tags()))
    var tags = _tags

    private val _searchText = MutableStateFlow("")
    var searchText = _searchText

    private val _filtersCheckedStates = SnapshotStateList<Int>()
    var filtersCheckedState = _filtersCheckedStates

    var bought = mutableStateOf(false)
    fun resetCart(){
        _totalPrice.intValue = 0
        _order.value = emptyList()
    }
    private fun getAllProducts(){
        _allProducts.value = getAllProducts.invoke()
    }
    fun addToCart(products: Products){
        if(products in _order.value){
            products.quantity += 1
        }else{
            _order.value += products
            products.quantity += 1
        }
        _totalPrice.intValue += products.price_current!!
    }
    fun removeFromCart(products: Products){
        products.quantity -= 1
        if(products.quantity == 0){
            _order.value -= products
        }
        _totalPrice.intValue -= products.price_current!!
    }
    fun getTags(){
        _tags.value = getTags.invoke()
    }
    fun changeCategory(newCategory: Int){
        _currentCategory.intValue = newCategory
    }
    fun getCategories(){
        _categories.value = getCategories.invoke()
    }
    fun getProductByCategory(){
        _products.value = _allProducts.value.filter {
            it.category_id == currentCategory.intValue
        }
    }
    init{
        getCategories()
        getTags()
        getAllProducts()
        getProductByCategory()
    }
    fun onSearchTextChange(text: String){
        _searchText.value = text
        _foundedProducts.value = _allProducts.value.filter{
            it.name.contains(text, true) || it.description!!.contains(text, true)
        }
    }
    fun showCheckedProducts(){
        _products.value = getProductsByTags.invoke(_filtersCheckedStates, currentCategory.intValue)
    }
}