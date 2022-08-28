package com.example.tictactoe.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.presentation.view.component.Board
import com.example.tictactoe.presentation.view.state.ViewState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GamePlay() {
    var state by remember { mutableStateOf(ViewState()) }

    fun onSquareSelected(index: Int) {
        state = state.selectSquare(index)
    }

    fun onPlayAgainClicked() {
        state = ViewState()
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome To TicTacToe",
            fontSize = LocalConfiguration.current.fontScale.times(25).sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/30))
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = state.info,
            color = Color.Black,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Board(
            squares = state.squares,
            isBoardEnabled = !state.isFinished,
            onClick = ::onSquareSelected,
        )
        if (state.isFinished) {
            Button(
                modifier = Modifier.padding(top = 16.dp),
                border = BorderStroke(1.dp, Color.Black),
                onClick = ::onPlayAgainClicked,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Cyan,
                )
            ) {
                Text(
                    text = "Play again",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.button,
                )
            }
        }
    }
}