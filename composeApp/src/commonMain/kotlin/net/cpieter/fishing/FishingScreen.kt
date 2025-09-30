package net.cpieter.fishing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fishing.composeapp.generated.resources.Res
import fishing.composeapp.generated.resources.fish_bucket
import fishing.composeapp.generated.resources.fishing_rod
import fishing.composeapp.generated.resources.lake
import fishing.composeapp.generated.resources.salmon
import org.jetbrains.compose.resources.painterResource

@Composable
fun FishingScreen(
    player: Player
) {
    var catch by remember { mutableStateOf<Fish?>(null)}

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Background
        Image(
            painter = painterResource(Res.drawable.lake),
            contentDescription = "lake",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Foreground
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "${player.name} - score: ${player.score}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Button(onClick = { // Inventory button
                val fish = catch()
                player.inventory += fish
                catch = fish
                player.score += fish.value
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
            ){
                Image(
                    painter = painterResource(Res.drawable.fish_bucket),
                    contentDescription = "inventory",
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Fit
                )
            }
            // Empty space for upper half
            Spacer(modifier = Modifier.weight(2f))
            Text(
                text = "Inventory: ${player.inventory.joinToString { it.species.name }}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            // Lower half with centered content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))

                catch?.let { FishCard(it) }

                Image(
                    painter = painterResource(Res.drawable.salmon),
                    contentDescription = "fish",
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.weight(1f))

                // Button
                Button(onClick = {
                    val fish = catch()
                    player.inventory += fish
                    catch = fish
                    player.score += fish.value
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.DarkGray
                    )
                ) {
                    Image(
                        painter = painterResource(Res.drawable.fishing_rod),
                        contentDescription = "fish",
                        colorFilter = ColorFilter.tint(Color.DarkGray),
                        modifier = Modifier.size(48.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}