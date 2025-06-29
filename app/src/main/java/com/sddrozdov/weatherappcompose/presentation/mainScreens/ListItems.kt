package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.sddrozdov.weatherappcompose.domain.model.Weather
import com.sddrozdov.weatherappcompose.presentation.theme.Blue


@Composable
fun ListItem(weather: Weather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Blue),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = weather.localTime,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                )
                Text(
                    text = weather.condition,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                    )
                )
            }

            Text(
                text = "${weather.currentTemp.toInt()}°C",
                color = Color.Yellow,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                ),
                modifier = Modifier.padding(end = 12.dp)
            )

            AsyncImage(
                model = "https:${weather.iconUrl}",
                contentDescription = "Weather icon",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}