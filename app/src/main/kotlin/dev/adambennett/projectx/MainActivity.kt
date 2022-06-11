package dev.adambennett.projectx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import dev.adambennett.ui.PlatformName
import dev.adambennett.ui.core.MyApplicationTheme
import dev.adambennett.ui.layouts.Greeting

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(PlatformName)
                }
            }
        }
    }
}
