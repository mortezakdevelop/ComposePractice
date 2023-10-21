package com.example.composepractice.ui.list_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.list_screen.Cars
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun TextList(
    cars: Cars,
    fontSize: TextUnit = 20.sp,
    onCheckedItemsChange: (carName: String) -> Unit
) {

    var background by remember {
        mutableStateOf(Color.White)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .clickable {
                background = Color.Blue
            },
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = cars.isSelected, onCheckedChange = {
                onCheckedItemsChange(cars.carsName)
            })
            Text(
                text = cars.carsName,
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = fontSize
            )
        }
        Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        TextList(Cars("morteza", false), onCheckedItemsChange = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewDark() {
    ComposePracticeTheme {
        TextList(Cars("morteza", false), onCheckedItemsChange = {})
    }
}