package com.example.request_tz.presentation.catalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val tabItems = listOf(
    CategoriesList(
        id = 676153,
        name = "Горячие блюда"
    ),
    CategoriesList(
        id = 676154,
        name = "Суши"
    ),
    CategoriesList(
        id = 676155,
        name = "Соусы"
    ),
    CategoriesList(
        id = 676156,
        name = "Детское меню"
    ),
    CategoriesList(
        id = 676122,
        name = "Наборы"
    ),
    CategoriesList(
        id = 676129,
        name = "Подарочные сертификаты"
    ),
    CategoriesList(
        id = 676166,
        name = "Готовим дома"
    ),
)
val ItemCardItems = listOf(
    ItemCard(
        id = 1,
        categoryId = 676168,
        name = "Авокадо Кранч Маки 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 800,
        measure = 250,
        measure_unit = "г",
        tag_ids = listOf(
            1,2
        )
    ),
    ItemCard(
        id = 2,
        categoryId = 676713,
        name = "Сезам Ролл 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 0,
        measure = 250,
        measure_unit = "г",
        tag_ids = listOf(
            4
        )
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Митаки 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = null,
        measure = 250,
        measure_unit = "г",
        tag_ids = listOf()
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Митаки 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = null,
        measure = 250,
        measure_unit = "г",
        tag_ids = listOf(
            1,2
        )
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Митаки 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = null,
        measure = 250,
        measure_unit = "г",
        tag_ids = listOf(
            1,2
        )
    )
)
var currentCategory = mutableIntStateOf(tabItems[0].id)
var isCartVisible = mutableStateOf(false)
var sum = mutableFloatStateOf(0f)

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 0.dp
                )
                .weight(1f)
        ) {
            TopLine()
            Categories()
            ItemCardList()
        }
        AnimatedVisibility(
            visible = isCartVisible.value,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            FixedCartButton()
        }
    }
}

data class CategoriesList(
    val id: Int,
    val name: String
)
data class ItemCard(
    val id: Int,
    val categoryId: Int,
    val name: String,
    val description: String,
    val image: Int,
    val priceCurrent: Int,
    val priceOld: Int? = null,
    val measure: Int,
    val measure_unit: String,
    val tag_ids: List<Int>
)
data class Tags(
    val id: Int,
    val name: String
)