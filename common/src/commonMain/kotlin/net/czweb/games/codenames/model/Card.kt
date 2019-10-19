package net.czweb.games.codenames.model

data class Card(val color: String, val word: String){

    override fun toString(): String {
        return "$color and $word ${getPlatformName()}"
    }
}