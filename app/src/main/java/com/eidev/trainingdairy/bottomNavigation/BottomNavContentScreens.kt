package com.eidev.trainingdairy.bottomNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.eidev.trainingdairy.R

@Composable
fun DairyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Dairy Screen",
            fontWeight = FontWeight.Bold,
//            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ResultsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Results Screen",
            fontWeight = FontWeight.Bold,
//            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ExerciseScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Exercise Screen",
            fontWeight = FontWeight.Bold,
//            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}


@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Settings Screen",
            fontWeight = FontWeight.Bold,
//            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}
