package net.cpieter.fishing



class Player(
    val name: String,
    val id: Int,
    var score: Int = 0

) {
    val inventory: MutableList<Fish> = mutableListOf()
}
