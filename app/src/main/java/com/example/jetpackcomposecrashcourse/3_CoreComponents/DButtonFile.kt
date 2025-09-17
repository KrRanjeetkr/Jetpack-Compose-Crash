package com.example.jetpackcomposecrashcourse.`3_CoreComponents`

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun FilledButtonSample(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        // 1. Filled Button
       /* Button(
            onClick = {
                Toast.makeText(context, "Button is Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Filled Button")
        }*/

        // 2. Tonal Button(signing or add to cart)
       /* FilledTonalButton(
            onClick = {
                Toast.makeText(context, "Tonal Button is Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Tonal Button")
        }*/

        // 3. Outline Button(Cancel or Back)
        /*OutlinedButton(
            onClick = {
                Toast.makeText(context, "Outline Button is Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Outlined Button")
        }*/

        // 4. Elevated Button
       /* ElevatedButton(
            onClick = {
                Toast.makeText(context, "Elevated Button is Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Elevated Button")
        }*/

        // 5. Text Button
        TextButton(
            onClick = {
                Toast.makeText(context, "Text Button is Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Text Button")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun FilledButtonSamplePreview(){
    FilledButtonSample()
}

