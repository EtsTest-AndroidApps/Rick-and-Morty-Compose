package dev.mike.rick_and_morty_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import dev.mike.common.Constants.common
import dev.mike.commons.ui.theme.RickandMortyComposeTheme
import dev.mike.rick_and_morty_compose.components.AppContent

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            RickandMortyComposeTheme {

                ProvideWindowInsets() {

                    // A surface container using the 'background' color from the theme
                  /*  Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding()
                    ) {*/

                        AppContent()
                    //}
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name! $common")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickandMortyComposeTheme {
        Greeting("Android")
    }
}
