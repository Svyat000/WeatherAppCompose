package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LoadingIndicator() {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .size(72.dp)
            .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(36.dp),
            color = Color.Yellow,
            strokeWidth = 4.dp
        )
    }
}