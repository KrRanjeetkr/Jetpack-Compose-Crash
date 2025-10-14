package com.example.jetpackcomposecrashcourse.`24_BottomNavigation`

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorDirection
import com.example.bottombar.model.IndicatorStyle

data class BottomNavItem(
    val name: String,
    val icon: ImageVector,
    val unSelectedIcon: ImageVector
)

@Composable
fun BottomNavigationExample() {
    var selectedItem by remember { mutableIntStateOf(0) }

    val bottomNavItems = listOf(
        BottomNavItem("Home", Icons.Default.Home, Icons.Outlined.Home),
        BottomNavItem("WishList", Icons.Default.Favorite, Icons.Outlined.Favorite),
        BottomNavItem("Cart", Icons.Default.ShoppingCart, Icons.Outlined.ShoppingCart),
        BottomNavItem("Profile", Icons.Default.Person, Icons.Outlined.Person)
    )

    Scaffold(
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding())
            ) {
                AnimatedBottomBar(
                    selectedItem = selectedItem,
                    itemSize = bottomNavItems.size,
                    containerColor = Color.Transparent,
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    indicatorDirection = IndicatorDirection.TOP,
                    indicatorStyle = IndicatorStyle.LINE
                ) {
                    bottomNavItems.forEachIndexed { index, navigationItem ->
                        BottomBarItem(
                            modifier = Modifier.align(alignment = Alignment.Top),
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                when (index) {
                                    0 -> { /* Navigate to Home */ }
                                    1 -> { /* Navigate to Wishlist */ }
                                    2 -> { /* Navigate to Cart */ }
                                    3 -> { /* Navigate to Profile */ }
                                }
                            },
                            imageVector = navigationItem.icon,
                            label = navigationItem.name,
                            containerColor = Color.Transparent
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        // Add content here if needed
    }
}

@Preview(showSystemUi = true)
@Composable
fun BottomNavigationPreview() {
    BottomNavigationExample()
}
