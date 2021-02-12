package com.example.breakingbaddb.framework.presentation.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.breakingbaddb.R
import com.example.breakingbaddb.framework.presentation.components.CharacterCard
import com.example.breakingbaddb.framework.presentation.components.SeasonsChip
import com.example.breakingbaddb.framework.presentation.ui.details.CharacterDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = ComposeView(requireContext())
        view.apply {
            setContent {
                val bbChars = viewModel.characters.value
                val query = viewModel.query.value

                    Surface(elevation = 8.dp,
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.primary )
                    {
                        Column {

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Column {
                                    TextField(
                                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                                        value = query,
                                        onValueChange = {
                                            viewModel.onQueryChanged(it)
                                        },
                                        label = {
                                            Text("Search")
                                        },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Search
                                        ),
                                        leadingIcon = {
                                            Icon(Icons.Filled.Search)
                                        },
                                        onImeActionPerformed = { action, softKeyboardController ->
                                            if(action == ImeAction.Search) {
                                                viewModel.searchByName(query)
                                                softKeyboardController?.hideSoftwareKeyboard()
                                            }

                                        },
                                        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                        backgroundColor = MaterialTheme.colors.surface
                                    )
                                    ScrollableRow(modifier = Modifier.fillMaxWidth()) {
                                        for(shows in getAllSeasons()) {
                                            SeasonsChip(season = shows.value,
                                                onSelectedSeason = {
                                                    viewModel.onSelectedSeason(it)
                                                    viewModel.searchBySeasonAppearance(it)
                                                } )
                                        }
                                    }
                                    LazyColumn {
                                        itemsIndexed(items = bbChars) { index, bbChars ->
                                            CharacterCard(person = bbChars, onClick = {
                                                if(bbChars.char_id != null) {
                                                    val bundle = Bundle()
                                                    bundle.putSerializable(CharacterDetailsFragment.CHARACTERS,bbChars)
                                                    Log.i("LIST_FRAGMENT","Character ID: ${bbChars.char_id } / Name: ${bbChars.name}")
                                                    findNavController().navigate(R.id.action_characterListFragment_to_characterDetailsFragment,bundle)
                                                }
                                            })
                                        }
                                    }
                                }
                            }

                        }
                    }
            }
        }

        return view
    }
    
}