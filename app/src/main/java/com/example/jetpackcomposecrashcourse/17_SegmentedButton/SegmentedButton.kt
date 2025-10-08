package com.example.jetpackcomposecrashcourse.`17_SegmentedButton`

import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import java.security.cert.PKIXRevocationChecker

@Composable
fun SegmentedButtonExample(){

    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }

    var  option = listOf("Walk", "Ride", "Drive" )

    MultiChoiceSegmentedButtonRow {
        option.forEachIndexed{index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = option.size
                ),
                checked = selectedOptions[index],
                onCheckedChange = {
                    selectedOptions[index] = !selectedOptions[index]
                },
                icon = {
                    SegmentedButtonDefaults.Icon(selectedOptions[index])
                },
                label = {
                    when(label){
                        "Walk" -> Icon(ImageVector  = Icons.AutoMicrosft)
                    }
                }
            ) { }

        }
    }

}
