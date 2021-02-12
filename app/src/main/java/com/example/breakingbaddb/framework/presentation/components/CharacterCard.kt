package com.example.breakingbaddb.framework.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.breakingbaddb.R
import com.example.breakingbaddb.business.domain.model.Characters
import com.example.breakingbaddb.framework.presentation.utils.loadMugShot

@Composable
fun CharacterCard(
        person: Characters,
        onClick: () -> Unit,
) {
    Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.padding(
                    bottom = 6.dp,
                    top = 6.dp)
                    .fillMaxWidth()
                    .clickable(onClick = onClick),
            elevation = 8.dp
    ) {
        Column {
            person.img?.let { url ->
                val image = loadMugShot(url = url, defaultImage = R.drawable.avatar_icon ).value

                image?.let {
                    Image(bitmap = image.asImageBitmap(),
                        modifier = Modifier.fillMaxWidth().preferredHeight(540.dp),
                        contentScale = ContentScale.Crop)
                }
            }
            person.name?.let { name ->
                Row(modifier = Modifier.fillMaxWidth().padding(top = 12.dp,bottom = 12.dp,start = 8.dp,end = 8.dp)) {
                    Text(text = name,
                    modifier = Modifier.fillMaxWidth(0.85f).wrapContentWidth(Alignment.Start),style = MaterialTheme.typography.h4)
                }
            }
        }

    }
}