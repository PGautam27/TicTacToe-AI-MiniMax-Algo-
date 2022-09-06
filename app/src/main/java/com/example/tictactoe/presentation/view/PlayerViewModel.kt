package com.example.tictactoe.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.presentation.view.smartAi.AiPlayer
import com.example.tictactoe.presentation.view.state.ViewState
import java.lang.IllegalArgumentException

class PlayerViewModel(
    private val state : ViewState
):ViewModel() {

    private val state1 = MutableLiveData(state)
    val state2 : LiveData<ViewState> = state1

    val aiPlayer = AiPlayer(state2)

    fun onSquareSelected(index:Int){
        state1.value = state1.value?.selectSquare(index)
    }

    fun onPlayAgainClicked(){
        state1.value = ViewState()
    }


}

class PlayerViewModelFactory(private val state : ViewState) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)){
            return PlayerViewModel(state) as T
        }
        throw  IllegalArgumentException("Sorry man couldn't access viewModel")
    }

}