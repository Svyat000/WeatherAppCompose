package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sddrozdov.weatherappcompose.domain.model.DailyForecast
import com.sddrozdov.weatherappcompose.presentation.state.WeatherTab
import com.sddrozdov.weatherappcompose.presentation.theme.Blue
import kotlinx.coroutines.launch


@Composable
fun TabLayout(forecast: List<DailyForecast>) {
    val pagerState = rememberPagerState(pageCount = { WeatherTab.entries.size })
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Blue,
            contentColor = Color.Yellow,
            indicator = { tabPositions ->
                androidx.compose.material3.TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                    color = Color.Yellow,
                    height = 3.dp
                )
            }
        ) {
            WeatherTab.entries.forEachIndexed { index, currentTab ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = {
                        coroutineScope.launch { pagerState.animateScrollToPage(currentTab.ordinal) }
                    },
                    text = {
                        Text(
                            text = currentTab.name,
                            color = if (selectedTabIndex.value == index) Color.Yellow else Color.White.copy(alpha = 0.7f),
                            fontSize = 16.sp
                        )
                    }
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> HourlyForecastList(forecast.first().hourlyForecast)
                1 -> DailyForecastList(forecast)
            }
        }
    }
}