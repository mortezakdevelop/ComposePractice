package com.example.composepractice.ui.main

import android.widget.Space
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun MainScreen() {

    val context = LocalContext.current


    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val message by rememberSaveable {
            mutableStateOf("Hello android!")
        }

        var isVisible by rememberSaveable {
            mutableStateOf(true)
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(text = message)
        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            shape = RoundedCornerShape(8.dp), onClick = {
                isVisible = !isVisible
            }) {
            if (isVisible)
                Text(text = "Hide me!")
            else
                Text(text = "show me!")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        MainScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewDark() {
    ComposePracticeTheme {
        MainScreen()
    }
}