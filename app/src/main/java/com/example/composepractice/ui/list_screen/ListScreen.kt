package com.example.composepractice.ui.list_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.list_screen.component.TextList
import com.example.composepractice.ui.theme.ComposePracticeTheme


data class Cars(
    var carsName: String,
    var isSelected: Boolean
)

@Composable
fun ListScreen() {

    var names by rememberSaveable {
        mutableStateOf(
            listOf(
                Cars("pride", false),
                Cars("benz", false),
                Cars("samand", false),
                Cars("bmw", false)
            )
        )
    }

    LazyColumn(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //multi type recycler view
        item {
            Text(
                text = "Title",
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }

        items(names) { car ->
            TextList(cars = car, onCheckedItemsChange = {
                names = names.map { nameCar ->
                    if (nameCar.carsName == it) {
                        nameCar.copy(isSelected = !nameCar.isSelected)
                    } else
                        nameCar

                }
            })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        ListScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewDark() {
    ComposePracticeTheme {
        ListScreen()
    }
}