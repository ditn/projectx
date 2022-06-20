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

sealed interface Route

data class BasicRoute(val value: String, val screen: @Composable () -> Unit) : Route

data class RouteWithArgument(
    val value: String,
    val argName: String,
    val screen: @Composable (String) -> Unit,
) : Route

val destinationSet = setOf(
    BasicRoute("landing") { Greeting(name = PlatformName) },
    RouteWithArgument("landing/{someArgument}", "someArgument") { argument ->
        Greeting(name = argument)
    }
)

@Composable
private fun MyApp(navController: NavHostController) {
    NavHost(navController, startDestination = "landing") {
        destinationSet.forEach { route ->
            when (route) {
                is BasicRoute -> composable(route.value) { route.screen() }
                is RouteWithArgument -> composable(route.value) { backStackEntry ->
                    route.screen(backStackEntry.arguments?.getString(route.argName).orEmpty())
                }
            }
        }
    }
}
