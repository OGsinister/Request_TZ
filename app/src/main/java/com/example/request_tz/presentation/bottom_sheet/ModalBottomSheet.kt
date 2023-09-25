package com.example.request_tz.presentation.bottom_sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.request_tz.R
import com.example.request_tz.domain.model.Tags
import com.example.request_tz.ui.theme.mainColor
import com.example.request_tz.view_model.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheet(
    isBottomSheetVisible: MutableState<Boolean>,
    viewModel: MainViewModel
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    val tags = viewModel.tags.value

    ModalBottomSheet(
        onDismissRequest = {
            isBottomSheetVisible.value = false
            scope.launch(Dispatchers.Main) {
                sheetState.hide()
            }
        },
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Content(tags, viewModel)
    }
}
@Composable
fun Content(
    tags: List<Tags>,
    viewModel: MainViewModel
){
    val checkBoxStates = viewModel.filtersCheckedState
    Column(
        modifier = Modifier
            .padding(
                start = 24.dp,
                end = 24.dp,
                bottom = 32.dp
            )
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = stringResource(id = R.string.pick_up_product),
            fontSize = 20.sp,
            color = Color.Black.copy(alpha = 0.87f),
            fontWeight = FontWeight.Bold
        )
        Filters(tags, checkBoxStates)
        Button(
            onClick = {
                /**
                 * Конвертируем checkBoxStates в List, потому что
                 * в интерфейсе ApiRepository нельзя передать Snapshot
                 * */
                viewModel.showCheckedProducts()
            },
            colors = ButtonDefaults.buttonColors(mainColor),
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(text = stringResource(id = R.string.bottomSheetDialogButton))
        }
    }
}
@Composable
fun Filters(
    tags: List<Tags>,
    checkBoxStates: SnapshotStateList<Int>
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        LazyColumn{
            items(tags){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = it.name.toString(),
                        fontSize = 16.sp
                    )
                    Checkbox(
                        checked = checkBoxStates.contains(it.id),
                        onCheckedChange = { _ ->
                            if(!checkBoxStates.contains(it.id)){
                                checkBoxStates.add(it.id!!)
                            }else{
                                checkBoxStates.remove(it.id!!)
                            }
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = mainColor,
                            checkmarkColor = Color.White,
                            uncheckedColor = Color.Black.copy(alpha = 0.12f)
                        )
                    )
                }
            }
        }
    }
}