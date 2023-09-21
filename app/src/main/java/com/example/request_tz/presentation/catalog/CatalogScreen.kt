package com.example.request_tz.presentation.catalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.request_tz.R
import com.example.request_tz.ui.theme.mainColor

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
        priceOld = 0
    ),
    ItemCard(
        id = 2,
        categoryId = 676713,
        name = "Сезам Ролл 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 0
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Митаки 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 0
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Такеши Китано 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 0
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Филадельфия Кунжут 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 0
    ),
    ItemCard(
        id = 3,
        categoryId = 672524,
        name = "Йоко Оно 8шт",
        description = "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.Украшается соусом\\\"Унаги\\\" и легким майонезом  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
        image = 1,
        priceCurrent = 4700,
        priceOld = 0
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
    ){
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
        ){
            TopLine()
            Categories()
            ItemCardList()
        }

        AnimatedVisibility(
            visible = isCartVisible.value,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.12f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 12.dp
                        ),
                    onClick = {
                        /**
                         * navigate to Cart screen
                         */
                    },
                    colors = ButtonDefaults.buttonColors(mainColor)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cart),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = sum.floatValue.toString()
                    )
                }
            }
        }
    }
}

@Composable
fun Categories(){
    LazyRow{
        items(tabItems){
            CategoryList(category = it)
        }
    }
}

@Composable
fun ItemCardList(){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(ItemCardItems){
            ItemCardListItem(it)
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
    val priceOld: Int
)