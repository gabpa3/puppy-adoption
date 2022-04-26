package com.gabpa3.puppyadoption.ui.navigation

sealed class NavRoute(val route: String) {
    object HomeRoute : NavRoute("home")
    object DetailRoute : NavRoute("detail/{puppyId}")
}
