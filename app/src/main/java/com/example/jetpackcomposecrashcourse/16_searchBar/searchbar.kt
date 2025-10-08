//package com.example.jetpackcomposecrashcourse.`16_searchBar`
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.input.TextFieldState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.ListItem
//import androidx.compose.material3.SearchBar
//import androidx.compose.material3.SearchBarDefaults.InputField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.semantics.isTraversalGroup
//import androidx.compose.ui.semantics.semantics
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.jetpackcomposecrashcourse.`14_ProgressIndicater`.CircularIndicater
//
//@Composable
//fun SearchScreen() {
//    val textFieldState = remember { TextFieldState() }
//    var searchResult by remember { mutableStateOf(listOf<String>()) }
//
//    val onSearch: (String) -> Unit = { query ->
//        searchResult = listOf(
//            "result 1 for $query",
//            "result 2 for $query",
//            "result 3 for $query",
//            "result 4 for $query",
//            "result 5 for $query",
//        )
//    }
//
//    SimpleSearchBar(
//        textFieldState = textFieldState,
//        onSearch = onSearch,
//        searchResult = searchResult
//    )
//
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SimpleSearchBar(
//    textFieldState: TextFieldState,
//    onSearch: (String) -> Unit,
//    searchResult: List<String>,
//    modifier: Modifier = Modifier
//) {
//    var expended by rememberSaveable { mutableStateOf(false) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .semantics { isTraversalGroup = true }
//    ) {
//        SearchBar(
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .semantics { isTraversalGroup = true },
//            inputField = {
//                InputField(
//                    query = textFieldState.text.toString(),
//                    onQueryChange = { newText ->
//                        textFieldState.edit {
//                            replace(0, length, newText)
//                        }
//                    },
//                    onSearch = {
//                        onSearch(textFieldState.text.toString())
//                        expended = false
//                    },
//                    expanded = expended,
//                    onExpandedChange = { expended = it },
//                    placeholder = { Text(text = "Search...") }
//                )
//            },
//            expanded = expended,
//            onExpandedChange = { expended = it }
//
//        ) {
//            Column(
//                modifier = Modifier.verticalScroll(rememberScrollState())
//            ) {
//                searchResult.forEach { result ->
//                    ListItem(
//                        headlineContent = { Text(text = result) },
//                        modifier = Modifier
//                            .clickable {
//                                textFieldState.edit {
//                                    replace(0, length, result)
//                                }
//                                expended = false
//                            }
//                            .fillMaxWidth()
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun PreviewScaffold(){
//    SearchScreen()
//}


package com.example.jetpackcomposecrashcourse.`16_searchBar`

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    var query by rememberSaveable { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(listOf<String>()) }

    val onSearch: (String) -> Unit = { text ->
        searchResults = listOf(
            "Result 1 for $text",
            "Result 2 for $text",
            "Result 3 for $text",
            "Result 4 for $text",
            "Result 5 for $text",
        )
    }

    SimpleSearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = onSearch,
        searchResults = searchResults
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    var active by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            query = query,
            onQueryChange = onQueryChange,
            onSearch = {
                onSearch(query)
                active = false
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text("Search...") },
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text(result) },
                        modifier = Modifier
                            .clickable {
                                onQueryChange(result)
                                active = false
                            }
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewScaffold() {
    SearchScreen()
}
