package com.example.jetpackcomposecrashcourse.`7_CheckBox`

import android.widget.CheckBox
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckBoxExample() {
    // ✅ Use state list so UI updates correctly
    val childCheckState = remember {
        mutableStateListOf(false, false, false)
    }

    // ✅ Parent state depends on children
    val parentState = when {
        childCheckState.all { it } -> ToggleableState.On
        childCheckState.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Parent Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Select All")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    for (i in childCheckState.indices) {
                        childCheckState[i] = newState
                    }
                }
            )
        }

        // Child Checkboxes
        childCheckState.forEachIndexed { index, checked ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        childCheckState[index] = it
                    }
                )
            }
        }
    }

    // ✅ Show text when all selected
    if (childCheckState.all { it }) {
        Text("All Options Selected")
    }
}

/*@Composable
fun CheckBoxExample(){
    val childCheckState = remember {
        mutableListOf(false, false, false)
    }

    val parentState = when{
        childCheckState.all{it} -> ToggleableState.On
        childCheckState.none() -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Select All"
            )
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckState.forEachIndexed { index, bool ->
                        childCheckState[index] = newState
                    }
                }
            )
        }


        childCheckState.forEachIndexed{index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        childCheckState[index] = it
                    }
                )
            }

        }
    }

    if (childCheckState.all { it }){
        Text("All Option Selected")
    }
}*/


@Preview(showSystemUi = true)
@Composable
fun CheckPreview() {
    CheckBoxExample()
}
