package net.czweb.games.codenames.webapp

import java.util.*

class Registry {
    companion object {
        val connections: MutableList<String> = Collections.synchronizedList(mutableListOf())
    }
}