package net.cpieter.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import fishing.composeapp.generated.resources.Res
import fishing.composeapp.generated.resources.fish_bucket
import fishing.composeapp.generated.resources.fishing_rod
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

val LocalPlayer = compositionLocalOf { mutableStateOf(Player("Pascal", 1000001)) }

enum class Screen {
    FISHING,
    INVENTORY,
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        // State for the text field
        var currentScreen by remember { mutableStateOf(Screen.FISHING) }

        val player = remember { mutableStateOf(Player("Pascal", 1000001)) }

        CompositionLocalProvider(LocalPlayer provides player) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                // screen
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    when (currentScreen) {
                        Screen.FISHING -> FishingScreen()
                        Screen.INVENTORY -> InventoryScreen()
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))

                    //Buttons
                    Button(onClick = { // Inventory button
                        currentScreen = Screen.INVENTORY
                    },
                        shape = RoundedCornerShape ( 12.dp),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.DarkGray
                        ),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(56.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.fish_bucket),
                            contentDescription = "inventory",
                            modifier = Modifier.size(46.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))

                    //Buttons
                    Button(onClick = { // Fishing button
                        currentScreen = Screen.FISHING
                    },
                        shape = RoundedCornerShape ( 12.dp),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.DarkGray
                        ),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(56.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.fishing_rod),
                            contentDescription = "inventory",
                            modifier = Modifier.size(46.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}