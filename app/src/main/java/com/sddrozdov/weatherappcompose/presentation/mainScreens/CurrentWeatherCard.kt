package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.sddrozdov.weatherappcompose.R
import com.sddrozdov.weatherappcompose.domain.model.Weather
import com.sddrozdov.weatherappcompose.presentation.theme.Blue

//@Preview(showBackground = true)
@Composable
fun CurrentWeatherCard(weather: Weather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Blue),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = weather.localTime,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Yellow.copy(alpha = 0.85f)
                    )
                )
                AsyncImage(
                    model = weather.iconUrl,
                    contentDescription = "Weather icon",
                    modifier = Modifier.size(48.dp)
                )
            }

            Text(
                text = weather.city,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Yellow,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                ),
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "${weather.currentTemp.toInt()}°",
                style = TextStyle(
                    fontSize = 72.sp,
                    color = Color.Yellow,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = weather.condition,
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Yellow.copy(alpha = 0.9f),
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: Search action */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "Search icon",
                        tint = Color.Yellow
                    )
                }

                Text(
                    text = "${weather.tempMax.toInt()}° / ${weather.tempMin.toInt()}°",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Yellow,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
                    )
                )

                IconButton(onClick = { /* TODO: Refresh action */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_sync_24),
                        contentDescription = "Refresh icon",
                        tint = Color.Yellow
                    )
                }
            }
        }
    }
}