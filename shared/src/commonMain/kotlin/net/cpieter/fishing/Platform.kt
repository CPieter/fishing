package net.cpieter.fishing

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform