package com.example.request_tz.data.repository

import android.content.Context
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.model.Tags
import com.example.request_tz.domain.repository.ApiRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private val json = Gson()
class ApiRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): ApiRepository {
    override fun getCategories(): List<Categories> {
        return Categories().getJsonData(context)
    }
    override fun getProducts(categoryId: Int): List<Products> {
        return Products().getJsonData(context).filter {
            it.category_id == categoryId
        }
    }
    override fun getAllProducts(): List<Products> {
        return Products().getJsonData(context)
    }
    override fun getProductByTags(listId: List<Int>, categoryId: Int): List<Products> {
        return Products().getJsonData(context).filter {
            it.category_id == categoryId && it.tag_ids!!.containsAll(listId)
        }
    }

    override fun getTags(): List<Tags> {
        return Tags().getJsonData(context)
    }
}

fun Gson.getDataFromApi(name: String, context: Context): String {
    return context.assets.open("api/$name.json")
        .bufferedReader()
        .use { it.readText() }
}
fun Products.getJsonData(@ApplicationContext context: Context): List<Products> {
    return json.fromJson(
        json.getDataFromApi("Products",context), Array<Products>::class.java
    ).toList()
}
fun Categories.getJsonData(@ApplicationContext context: Context): List<Categories>{
    return json.fromJson(
        json.getDataFromApi("Categories", context), Array<Categories>::class.java
    ).toList()
}
fun Tags.getJsonData(@ApplicationContext context: Context): List<Tags> {
    return json.fromJson(
        json.getDataFromApi("Tags", context), Array<Tags>::class.java
    ).toList()
}