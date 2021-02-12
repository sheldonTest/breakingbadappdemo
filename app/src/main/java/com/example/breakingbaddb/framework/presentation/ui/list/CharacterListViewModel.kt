package com.example.breakingbaddb.framework.presentation.ui.list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbaddb.business.domain.model.Characters
import com.example.breakingbaddb.business.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterListViewModel
@ViewModelInject
constructor(
    private val repository: CharacterRepository

) : ViewModel() {
    val characters  : MutableState<List<Characters>> = mutableStateOf(listOf())
    val query = mutableStateOf("")
    val currentSeason : MutableState<SeasonsFilter?> = mutableStateOf(null)

    init {
        viewModelScope.launch {
          val result = repository.getCharacters()
            characters.value = result
        }
    }

    fun searchByName(query: String)  {
        viewModelScope.launch {
            val result = repository.searchByName(query)
            characters.value = result
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

    fun onSelectedSeason(season: Int) {
        val selectedSeason = getSeasons(season)
        currentSeason.value = selectedSeason
    }

    fun searchBySeasonAppearance(season: Int) {
        viewModelScope.launch {
            val result = repository.searchBySeasonAppearance(listOf(season))
            Log.i("VIEW_MODEL",listOf(season).toString())
            characters.value = result
        }
    }


}