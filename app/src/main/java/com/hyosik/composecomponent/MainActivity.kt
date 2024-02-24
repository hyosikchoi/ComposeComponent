package com.hyosik.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hyosik.composecomponent.screen.DetailScreen
import com.hyosik.composecomponent.screen.MainScreen
import com.hyosik.composecomponent.ui.theme.ComposeComponentTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PokeLevel()
                }
            }
        }
    }
}

@Composable
fun PokeLevel(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "Home",
        modifier = modifier
    ) {
        composable("Home") {
            MainScreen(
                onPokemonClick = {
                    val pokemonId = it.substringAfter("pokemon/")
                        .substringBefore("/")
                        .toInt()
                    navController.navigate("Detail/${pokemonId}")
                },
                /** hilt 사용시 viewModel() 이 아닌 hiltViewModel() 을 사용해야 한다! 중요! */
                viewModel = hiltViewModel()
            )
        }

        // 단계 3: arguments 파라미터를 설정하자.
        // ```
        // navArgument("pokemenId") {
        // type = NavType.IntType
        // }
        // ```
        // 리스트로 전달해야 한다.
        composable(
            "Detail/{pokemonId}",
            arguments = listOf(
                navArgument("pokemonId") {
                    type = NavType.IntType
                }
            )
        ) {
            // 단계 4: `pokemonId`를 `Int`값으로 가져오자. (`arguments?.getInt`를 이용)
            val pokemonId = it.arguments?.getInt("pokemonId") ?: 0
            DetailScreen(
                pokemonId = pokemonId,
                onUpButtonClick = {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                },
                viewModel = hiltViewModel()
            )
        }
    }
}