package com.example.breakingbaddb.framework.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.breakingbaddb.R
import com.example.breakingbaddb.business.domain.model.Characters
import com.example.breakingbaddb.framework.presentation.utils.loadMugShot

class CharacterDetailsFragment : Fragment() {

    companion object {
        val CHARACTERS = "CHAR_KEY"
    }
    private lateinit var characters: Characters
    private var charName : String? = null
    private var imageUrl : String? = null
    private var status : String? = null
    private var nickName: String? = null
    private lateinit var apperance: List<Int>
    private lateinit var occupation: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       characters = arguments?.getSerializable(CHARACTERS) as Characters

        charName = characters.name
        imageUrl = characters.img
        status = characters.status
        nickName = characters.nickname
        apperance = characters.appearance
        occupation = characters.occupation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ComposeView(requireContext())
        view.apply {
            setContent {
               ScrollableColumn(modifier = Modifier.fillMaxWidth()) {
                   imageUrl?.let { url ->
                       val mugShot = loadMugShot(url = url, defaultImage = R.drawable.avatar_icon).value
                       mugShot?.let { img ->
                           Image(bitmap = img.asImageBitmap(),
                                   modifier = Modifier.fillMaxWidth().preferredHeight(540.dp),
                                   contentScale = ContentScale.Crop)
                       }
                   }
                   Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                       charName?.let { name ->
                           Row(modifier = Modifier.fillMaxWidth()) {
                               Text(text = name,
                                       modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                                       style = MaterialTheme.typography.h3)
                           }
                       }
                       Text(text = "Occupation:",
                               modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                               style = MaterialTheme.typography.h6)

                       occupation.let {
                           for(role in it) {
                               Row(modifier = Modifier.fillMaxWidth()) {
                                   Text(text = role,
                                           modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                                           style = MaterialTheme.typography.h6)
                               }
                           }
                       }
                       status?.let { stats ->

                           Row(modifier = Modifier.fillMaxWidth()) {
                               Text(text = "Status: $stats" ,
                                       modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                                       style = MaterialTheme.typography.h6)
                           }
                       }
                       nickName?.let { nickName->
                           Row(modifier = Modifier.fillMaxWidth()) {
                               Text(text = "Nickname: $nickName",
                                       modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                                       style = MaterialTheme.typography.h5)
                           }
                       }
                       Text(text = "Season Appearance:",
                               modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                               style = MaterialTheme.typography.h6)
                       apperance.let {
                           for(seen in it) {
                               Row(modifier = Modifier.fillMaxWidth()) {
                                   Text(text = seen.toString(),
                                           modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start),
                                           style = MaterialTheme.typography.h6)
                               }
                           }
                       }
                   }
               }
            }
            return view
        }

    }


}