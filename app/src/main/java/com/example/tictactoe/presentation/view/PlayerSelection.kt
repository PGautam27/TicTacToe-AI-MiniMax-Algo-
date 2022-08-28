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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Choose What you wanna be")
        Spacer(modifier = Modifier.padding(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                player.value = "x"
            }, modifier = Modifier.size(100.dp), colors = ButtonDefaults.buttonColors(
                backgroundColor = if (player.value == "x") Color.Cyan else Color.Gray,
            )
            ) {
                Text(text = "X", fontSize = 40.sp)
            }
            Button(onClick = {
                player.value = "y"
            }, modifier = Modifier.size(100.dp),colors = ButtonDefaults.buttonColors(
                backgroundColor = if (player.value =="y") Color.Cyan else Color.Gray ,
            )) {
                Text(text = "Y", fontSize = 40.sp)
            }
        }


    }
}