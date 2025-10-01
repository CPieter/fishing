package net.cpieter.fishing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FishCard(
    fish: Fish
) {
    val player by LocalPlayer.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = fish.species.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Weight: ${fish.weight} kg",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Value: ${fish.value} geld",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}