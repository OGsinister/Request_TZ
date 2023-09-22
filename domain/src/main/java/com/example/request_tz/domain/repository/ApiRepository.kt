package com.example.request_tz.domain.repository

import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.model.Tags

interface ApiRepository {
    fun getCategories(): List<Categories>
    fun getProducts(categoryId: Int): List<Products>
    fun getTags(): List<Tags>
}