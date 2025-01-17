package dev.mike.rick_and_morty_compose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.devmike.ui_episodes.navigation.episodesGraph
import com.devmike.ui_locations.locationsGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import dev.mike.common.Characters
import dev.mike.common.Episodes
import dev.mike.common.Locations
import dev.mike.commons.components.ComingSoonBox
import dev.mike.ui_characters.navigation.charactersGraph
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun MainNavigation(navhostController: NavHostController) {

    AnimatedNavHost(navController = navhostController, startDestination = Characters.CHARACTERSGRAPH) {

        charactersGraph(navhostController)
  episodesGraph(navhostController)
        locationsGraph(navhostController)

    }
}
