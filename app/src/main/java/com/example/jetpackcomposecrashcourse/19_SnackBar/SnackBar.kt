package com.example.jetpackcomposecrashcourse.`19_SnackBar`

import androidx.annotation.RestrictTo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackBarExample(){
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope() // ✅ define coroutine scope here
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }, floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Show SnackBar") },
                icon = { Icon(Icons.Filled.Image, contentDescription = "Image Icon") },
                onClick = {
                    scope.launch{
                        val result = snackBarHostState.showSnackbar(
                            message = "SnackBat",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Indefinite
                        )
                        when(result){
                            SnackbarResult.ActionPerformed -> {
                                //Handle Perform Action
                            }

                            SnackbarResult.Dismissed -> {
                                //Dismiss Any Action
                            }
                        }
                    }
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
            ) {
                Text( text = "Tab the fab to show Snackbar")
            }

        }
    )
}


@Preview(showSystemUi = true)
@Composable
fun PreviewSegmentedButton(){
    SnackBarExample()
}
