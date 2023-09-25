import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.domain.model.Products
import com.example.request_tz.presentation.card_item.util.ShowDescription
import com.example.request_tz.presentation.card_item.util.ShowName
@Composable
fun Content(
    product: Products
){
    Row(
        modifier = Modifier
            .padding(start = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text(
            text = product.name,
            fontSize = 34.sp
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ){
        ShowName(product)
        Spacer(modifier = Modifier.padding(15.dp))
    }
    ShowDescription(product)
}