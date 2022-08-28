package com.example.tictactoe.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayerSelection() {
    val player = remember {
        mutableStateOf(String())
    }
    val selectedX = remember {
        mutableStateOf(false)
    }
    val selectedY = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Choose What you wanna be")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                player.value = "x"
                selectedX.value = true
                selectedY.value = false
            }, modifier = Modifier.size(200.dp), colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                disabledBackgroundColor = Color.Gray,
            ), enabled = selectedX.value
            ) {
                Text(text = "X", fontSize = 40.sp)
            }
            Button(onClick = {
                player.value = "y"
                selectedX.value = false
                selectedY.value = true
            }, modifier = Modifier.size(200.dp),colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                disabledBackgroundColor = Color.Gray,
            ), enabled = selectedX.value) {
                Text(text = "Y", fontSize = 40.sp)
            }
        }
    }
}