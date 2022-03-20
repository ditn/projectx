package dev.adambennett.ui

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import dev.adambennett.ui.layouts.Greeting

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Design component catalog",
        state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        Greeting(PlatformName)
    }
}
