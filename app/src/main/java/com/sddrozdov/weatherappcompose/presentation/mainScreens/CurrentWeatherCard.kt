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
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Blue),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(top = 8.dp, start = 10.dp),
                    text = weather.localTime, style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Yellow
                    )
                )
                AsyncImage(
                    model = weather.iconUrl,
                    contentDescription = "imageWeatherApi",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 3.dp, end = 9.dp)
                )
            }
            Text(
                text = weather.city, style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Yellow
                )
            )
            Text(
                text = weather.currentTemp.toString(), style = TextStyle(
                    fontSize = 60.sp,
                    color = Color.Yellow
                )
            )
            Text(
                text = weather.condition, style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Yellow
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {

                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "icon2"
                    )
                }
                Text(
                    text = "${weather.tempMax}/${weather.tempMin}", style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Yellow
                    )
                )
                IconButton(onClick = {

                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_sync_24),
                        contentDescription = "icon3"
                    )
                }
            }
        }
    }
}