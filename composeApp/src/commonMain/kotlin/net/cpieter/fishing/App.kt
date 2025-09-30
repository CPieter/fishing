package net.cpieter.fishing

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview


enum class Screen {
    FISHING,
    INVENTORY,
}
@Composable
@Preview
fun App() {
    MaterialTheme {
        // State for the text field
        val player by remember { mutableStateOf(Player("Pascal", 1000001)) }
        var currentScreen by remember { mutableStateOf(Screen.FISHING) }

        when (currentScreen) {
            Screen.FISHING -> FishingScreen(player)
            Screen.INVENTORY -> InventoryScreen
        }

    }
}