package dev.mike.ui_characters.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import dev.mike.common.Characters
import dev.mike.ui_characters.CharactersList
import dev.mike.ui_characters.characterDetails.CharacterDetailsScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.charactersGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = Characters.CHARACTERlIST,
        route = Characters.CHARACTERSGRAPH
    ) {

        composable(
            route = Characters.CHARACTERlIST,
            enterTransition = { //initial: NavBackStackEntry, target: NavBackStackEntry ->

                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
            },
            exitTransition = {//initial: NavBackStackEntry, target: NavBackStackEntry ->

                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700))
            },
            popEnterTransition = {//initial: NavBackStackEntry, target: NavBackStackEntry ->

                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700))
            },
            popExitTransition = {//initial: NavBackStackEntry, target: NavBackStackEntry ->

                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
            }

        ) {

            CharactersList { characterId ->
                navHostController.navigate(Characters.CHARACTERDETAILS+"/$characterId") {
                    launchSingleTop
                }
            }
        }

        composable(
            route = Characters.CHARACTERDETAILS+"/{characterId}",
            arguments = listOf(
                navArgument(
                    name = "characterId",
                ) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId")
            characterId?.let {

                CharacterDetailsScreen(
                    id = characterId
                )
            }
        }
    }
}