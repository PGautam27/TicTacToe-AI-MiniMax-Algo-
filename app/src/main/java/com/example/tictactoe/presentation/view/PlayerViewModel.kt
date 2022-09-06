package com.example.tictactoe.presentation.view

import android.util.Log
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

//    init {
//        aiPlayer()
//    }

    val humanOrAi = MutableLiveData<String>(state1.value?.info)

//    private fun aiPlayer(){
//        viewModelScope.launch(Dispatchers.Main) {
//            Log.v("working","Let's see")
//            if (state2.value?.info == "Next player: O"){
//                Log.v("working","super")
//                    chooseBoard()
//            }
//        }
//    }

    fun RandomComputerPlayer() {
        val indexValues = state1.value?.squares
//        val predicate : (String) -> Boolean = {it == ""}
        val listIndexes = ArrayList<Int>()
        indexValues?.forEachIndexed { index, s ->
            if (s == "") {
                listIndexes.add(index)
            }
        }
        onSquareSelected(listIndexes.random())
    }

    fun onSquareSelected(index:Int){
        state1.value = state1.value?.selectSquare(index)
        viewModelScope.launch(Dispatchers.Main) {
            if (state2.value?.info == "Next player: O"){
                Log.v("working","super")
                RandomComputerPlayer()
            }
        }
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