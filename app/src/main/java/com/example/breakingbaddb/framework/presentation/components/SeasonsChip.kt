package com.example.breakingbaddb.framework.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SeasonsChip(
    season: Int,
    onSelectedSeason: (Int) -> Unit,
) {
    
    Surface(
        modifier = Modifier.padding(20.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.primary
    ) {

        Row(modifier = Modifier.clickable(onClick = { onSelectedSeason(season) }) ) {
            Text(text = season.toString(),
            style = MaterialTheme.typography.body2,
            color = Color.White,
                modifier = Modifier.padding(8.dp) )
        }

    }
}