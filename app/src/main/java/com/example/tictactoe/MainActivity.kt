package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.presentation.view.GamePlay
import com.example.tictactoe.presentation.view.PlayerSelection
import com.example.tictactoe.presentation.view.PlayerViewModel
import com.example.tictactoe.presentation.view.PlayerViewModelFactory
import com.example.tictactoe.presentation.view.state.ViewState
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = PlayerViewModelFactory(ViewState())
        val viewModel = ViewModelProvider(this,viewModelFactory).get(PlayerViewModel::class.java)
        setContent {
            TicTacToeTheme {
                //PlayerSelection()
                GamePlay(viewModel = viewModel)
            }
        }
    }
}

