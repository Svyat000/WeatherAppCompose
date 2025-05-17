package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.Arrangement
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


//@Preview(showBackground = true)
@Composable
fun ListItem(weather: Weather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Blue),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(start = 5.dp, top = 3.dp, bottom = 3.dp)) {
                Text(text = weather.localTime)
                Text(text = weather.condition)
            }

            Text(
                text = "${weather.currentTemp.toInt()}°C",
                color = Color.Yellow,
                style = TextStyle(fontSize = 20.sp)
            )
            AsyncImage(
                model = "https:${weather.iconUrl}",
                contentDescription = "imageWeatherApi",
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 3.dp, end = 9.dp)
            )
        }
    }
}