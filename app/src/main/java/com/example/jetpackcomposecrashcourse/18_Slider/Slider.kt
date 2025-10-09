package com.example.jetpackcomposecrashcourse.`18_Slider`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecrashcourse.`17_SegmentedButton`.SegmentedButtonExample

@Composable
fun SliderExample(){
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Slider(modifier = Modifier.fillMaxSize(),
            value = sliderPosition,
            onValueChange = { sliderPosition = it},
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTickColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            steps = 10,
            valueRange = 0f.. 50f,
        )
        Text(text = sliderPosition.toString())
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSegmentedButton(){
    SliderExample()
}

