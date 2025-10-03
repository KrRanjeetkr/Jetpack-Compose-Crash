package com.example.jetpackcomposecrashcourse.`13_NavigationDrawer`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationExample(){

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope ()

    ModalNavigationDrawer(
      drawerContent = {
          ModalBottomSheet(
              onDismissRequest = {}
          ){
              Column(
                  modifier = Modifier.padding(horizontal = 16.dp).verticalScroll(
                      rememberScrollState()
                  )
              ) {
                  Text(text = "Drawer Title")
                  HorizontalDivider()
                  Text(text = "Content of drawer")
              }
          }
      }
    ) { }

}
