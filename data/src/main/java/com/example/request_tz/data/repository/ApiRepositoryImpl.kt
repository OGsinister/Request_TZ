package com.example.request_tz.data.repository

import android.content.Context
import com.example.request_tz.domain.model.Categories
import com.example.request_tz.domain.model.Products
import com.example.request_tz.domain.model.Tags
import com.example.request_tz.domain.repository.ApiRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): ApiRepository {
    private var json = Gson()

    override fun getCategories(): List<Categories> {
        return json.fromJson(
            json.getDataFromApi("Categories",context), Array<Categories>::class.java
        ).toList()
    }

    override fun getProducts(): List<Products> {
        return json.fromJson(
            json.getDataFromApi("Products",context), Array<Products>::class.java
        ).toList()
    }

    override fun getTags(): List<Tags> {
        return json.fromJson(json.getDataFromApi("Tags", context), Array<Tags>::class.java).toList()
    }
}

fun Gson.getDataFromApi(name: String, context: Context): String {
    return context.assets.open("api/$name.json")
        .bufferedReader()
        .use { it.readText() }
}
