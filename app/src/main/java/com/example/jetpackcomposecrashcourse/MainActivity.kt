package com.example.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`.AccessImageResources
import com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`.AccessStringResource
import com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`.GreatingText
import com.example.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCrashCourseTheme {
                AccessImageResources()
            }
        }
    }
}