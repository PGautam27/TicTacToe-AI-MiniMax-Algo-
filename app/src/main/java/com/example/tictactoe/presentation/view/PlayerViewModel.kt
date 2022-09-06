package com.example.tictactoe.presentation.view

import androidx.lifecycle.*
import com.example.tictactoe.presentation.view.smartAi.AiPlayer
import com.example.tictactoe.presentation.view.state.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class PlayerViewModel(
    state : ViewState
):ViewModel() {

    private val state1 = MutableLiveData(state)
    val state2 : LiveData<ViewState> = state1

    val aiPlayer = AiPlayer(state2)

    init {
        aiPlayer()
    }

    val humanOrAi = MutableLiveData<String>(state1.value?.info)

    private fun aiPlayer(){
        viewModelScope.launch(Dispatchers.IO) {
            if (humanOrAi.value == "Next player: O"){
                state1.value = aiPlayer.chooseBoard(state2.value!!)
            }
        }
    }



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