package com.example.jetpackcomposecrashcourse.`4_LayoutComposable`

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Modifiers are available in all the composable like, text, button, image, column, row etc.

@Composable
fun ModifierExample() {
    Box(
        modifier = Modifier
            .size(500.dp)
            .background(color = Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is jetpack compose",
            modifier = Modifier
                .background(Color.Yellow)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ModifierPreview() {
    ModifierExample()
}
