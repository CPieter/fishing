package net.cpieter.fishing

import kotlin.random.Random

fun catch(): String {
    return when (Random.nextInt(5)) {
        1 -> "You caught a big fish!"
        else -> "You caught a small fish!"
    }
}