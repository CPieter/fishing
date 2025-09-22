package net.cpieter.fishing

val allSpecies = listOf(
    FishSpecies("Salmon",   2..7,    2.2),
    FishSpecies("Tuna",     50..400, 3.0),
    FishSpecies("Halibut",  20..200, 2.7),
    FishSpecies("Shark",    100..600,2.9),
    FishSpecies("Stingray", 10..80,  1.8),
    FishSpecies("Catfish",  2..30,   1.5),
    FishSpecies("Sea bass", 1..8,    1.3),
)

fun catch(): Fish {
    val species = allSpecies.random()
    val weight = species.weightRange.random()
    return Fish(species, weight)
}

class Fish(
    val species: FishSpecies,
    val weight: Int,
) {
    val value: Double
        get() = weight * species.valueMultiplier
}

class FishSpecies(
    val name: String,
    val weightRange: IntRange,
    val valueMultiplier: Double,
)