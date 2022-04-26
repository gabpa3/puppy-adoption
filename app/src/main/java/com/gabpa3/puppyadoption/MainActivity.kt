/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gabpa3.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gabpa3.puppyadoption.ui.navigation.NavRoute
import com.gabpa3.puppyadoption.ui.screen.DetailScreen
import com.gabpa3.puppyadoption.ui.screen.HomeScreen
import com.gabpa3.puppyadoption.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
               Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(NavRoute.HomeRoute.route) {
            HomeScreen(onDetail = {
                navController.navigate("detail/$it")
            })
        }
        composable(
            NavRoute.DetailRoute.route,
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt("puppyId")
            requireNotNull(id)
            DetailScreen(id, onUpClick = { navController.popBackStack() })
        }
    }
}
