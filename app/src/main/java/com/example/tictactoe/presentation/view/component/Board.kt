package com.example.tictactoe.presentation.view.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable


@ExperimentalFoundationApi
@Composable
fun Board(squares: List<String>, isBoardEnabled: Boolean, onClick: (Int) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
    ) {
        items(squares.size) { index ->
            Square(squares[index], isBoardEnabled) { onClick(index) }
        }
    }
}