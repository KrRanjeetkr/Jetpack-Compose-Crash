package com.example.jetpackcomposecrashcourse.`3_CoreComponents`

import android.icu.number.Scale
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecrashcourse.R
import kotlin.collections.listOf

@Composable
fun ImageShow(){
    val rainbowColor = remember {
        Brush.sweepGradient(
            listOf(
                Color.Blue,
                Color.Cyan,
                Color.Yellow,
                Color.Green,
                Color.Magenta
            )
        )
    }

    val borderWidth = 4.dp

    Image(
        painter = painterResource(R.drawable.news),
        contentDescription = "This news image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(300.dp).border(
            BorderStroke(borderWidth, rainbowColor)
        )
//            .clip(CircleShape),
            ,
        alignment = Alignment.Center,
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
            setToSaturation(0f)
        })
    )
}


@Preview(showSystemUi = true)
@Composable
fun ImagePreview(){
    ImageShow()
}