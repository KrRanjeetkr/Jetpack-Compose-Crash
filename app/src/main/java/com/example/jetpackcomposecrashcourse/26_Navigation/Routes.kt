package com.example.jetpackcomposecrashcourse.`26_Navigation`

import kotlinx.serialization.Serializable

sealed class Navigation{
    @Serializable
    object Main: Navigation()
}

sealed class Routes{
    @Serializable
    object Home: Routes()

    @Serializable
    object Wishlist: Routes()
}
