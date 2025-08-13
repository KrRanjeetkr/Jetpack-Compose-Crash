package com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.jetpackcomposecrashcourse.R

@Composable
fun AccessStringResource() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(R.string.name), color = colorResource(R.color.black))
    }
}

@Composable
fun AccessImageResources() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.broadcasting),
            contentDescription = "Android logo"
        )
    }
}

