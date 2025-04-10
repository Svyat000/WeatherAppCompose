package com.sddrozdov.weatherappcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sddrozdov.weatherappcompose.R

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(painter = painterResource(R.drawable.sky_background), contentDescription = "skyback")


}