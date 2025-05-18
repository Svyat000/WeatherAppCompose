package com.sddrozdov.weatherappcompose.presentation.mainScreens


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMessage(message: String) {
    Text(
        text = "Error: $message",
        color = Color.Red,
        modifier = Modifier.padding(16.dp)
    )
}