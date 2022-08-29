package com.example.tictactoe.presentation.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoe.presentation.view.state.ViewState

class PlayerViewModel(
    private val state : ViewState
):ViewModel() {

    val state1 = MutableLiveData(state)

    fun onSquareSelected(index:Int){
        state1.value = state1.value?.selectSquare(index)
    }

    fun onPlayAgainClicked(){
        state1.value = ViewState()
    }

}