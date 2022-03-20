package dev.adambennett.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.adambennett.ui.core.MyApplicationTheme
import dev.adambennett.ui.layouts.Greeting

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting(PlatformName)
    }
}
