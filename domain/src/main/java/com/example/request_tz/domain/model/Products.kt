package com.example.request_tz.domain.model

data class Products(
    val carbohydrates_per_100_grams: Double? = null,
    val category_id: Int? = null,
    val description: String? = null,
    val energy_per_100_grams: Double? = null,
    val fats_per_100_grams: Double? = null,
    val id: Int? = null,
    val image: String? = null,
    val measure: Int? = null,
    val measure_unit: String? = null,
    val name: String = "",
    val price_current: Int? = null,
    val price_old: Int? = null,
    val proteins_per_100_grams: Double? = null,
    val tag_ids: List<Int>? = null,
    var quantity: Int = 0,
)