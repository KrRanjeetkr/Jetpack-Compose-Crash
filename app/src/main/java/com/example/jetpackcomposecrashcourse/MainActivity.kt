package com.example.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.InputChip
import com.example.jetpackcomposecrashcourse.`11_Menus`.DropdownExample
import com.example.jetpackcomposecrashcourse.`12_scaffold`.ScaffoldExample
import com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`.AccessImageResources
import com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`.AccessStringResource
import com.example.jetpackcomposecrashcourse.`2_Fundamental_Concepts`.GreatingText
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.AnnotatedStringWithListeners
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.ColorFullText
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.FilledButtonSample
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.ImageShow
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.PartiallySelectlableText
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.PasswordTextFieldSample
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.ScrollableTwoLineText
import com.example.jetpackcomposecrashcourse.`3_CoreComponents`.SimpleText
import com.example.jetpackcomposecrashcourse.`4_LayoutComposable`.columnExample
import com.example.jetpackcomposecrashcourse.`5_BottomSheet`.PartialBottomSheet
import com.example.jetpackcomposecrashcourse.`6_Cards`.ElevatedCardExample
import com.example.jetpackcomposecrashcourse.`7_CheckBox`.CheckBoxExample
import com.example.jetpackcomposecrashcourse.`8_InputChips`.inputChipExample
import com.example.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCrashCourseTheme {
                ScaffoldExample()
            }
        }
    }
}