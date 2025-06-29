package com.sddrozdov.weatherappcompose.presentation.mainScreens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMessage(message: String, modifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .background(Color(0xFFFFEBEE), shape = RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Icon(
            imageVector = androidx.compose.material.icons.Icons.Default.Build,
            contentDescription = "Error icon",
            tint = Color.Red,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Error: $message",
            color = Color.Red,
            style = TextStyle(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.weight(1f)
        )
    }
}