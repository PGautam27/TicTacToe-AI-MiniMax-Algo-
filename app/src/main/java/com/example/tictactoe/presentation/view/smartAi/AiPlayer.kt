package com.example.tictactoe.presentation.view.smartAi

import androidx.lifecycle.LiveData
import com.example.tictactoe.presentation.view.state.ViewState

class AiPlayer(state: LiveData<ViewState>){

    fun chooseBoard(state: ViewState): ViewState {
        val indexValues = state.squares
//        val predicate : (String) -> Boolean = {it == ""}
        val listIndexes = ArrayList<Int>()
        indexValues.forEachIndexed { index, s ->
            if (s == "") {
                listIndexes.add(index)
            }
        }

        val x = listIndexes.random()

        state.selectSquare(listIndexes.random())

        return state

    }

}