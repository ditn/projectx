package dev.adambennett.projectx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.adambennett.ui.PlatformName
import dev.adambennett.ui.core.MyApplicationTheme
import dev.adambennett.ui.layouts.Greeting

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(navController)
                }
            }
        }
    }
}


@Composable
private fun MyApp(navController: NavHostController) {
    NavHost(navController, startDestination = "landing") {
        composable("landing") {
            // TODO: this can be done a level down, but then how does this work in JVM-only UI?
//            @Composable
//            fun .presentation.MyScreen() {
//                val viewModel = hiltViewModel<presentation.MyViewModel>()
//                ui.MyScreen(viewModel.state) {
//                    viewModel.events(it)
//                }
//            }

            Greeting(name = PlatformName)
        }
    }
}
