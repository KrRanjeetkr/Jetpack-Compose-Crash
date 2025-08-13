package com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// What is the Composable function

@Composable
fun GreatingText(){
    Text(text = "Hello world in jetpack compose")
}

@Preview(showSystemUi = true)
@Composable
fun GreatingPreview(){
    GreatingText()
}