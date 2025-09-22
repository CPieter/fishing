package net.cpieter.fishing

fun Double.format(decimals: Int = 2): String {
    val str = this.toString()
    val dotIndex = str.indexOf('.')
    return str.take(dotIndex + decimals)
}
