package net.cpieter.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fishing.composeapp.generated.resources.Res
import fishing.composeapp.generated.resources.fishing_rod
import fishing.composeapp.generated.resources.lake
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        // State for the text field
        var fishText by remember { mutableStateOf("") }

        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            // Background
            Image(
                painter = painterResource(Res.drawable.lake),
                contentDescription = "lake",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

            // Foreground
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                // Empty space for upper half
                Spacer(modifier = Modifier.weight(2f))

                // Lower half with centered content
                Column(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .weight(3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = fishText,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Button
                    Button(
                        onClick = {
                            val fish = catch()
                            fishText =
                                "You caught a ${fish.species.name.lowercase()} that is ${fish.weight} kg and worth ${fish.value.format()} geld"
                        },
                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.DarkGray,
                            ),
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.fishing_rod),
                            contentDescription = "fish",
                            colorFilter = ColorFilter.tint(Color.DarkGray),
                            modifier = Modifier.size(48.dp),
                            contentScale = ContentScale.Fit,
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
