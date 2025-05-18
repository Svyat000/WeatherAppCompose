package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.size(48.dp),
        color = Color.Yellow
    )
}