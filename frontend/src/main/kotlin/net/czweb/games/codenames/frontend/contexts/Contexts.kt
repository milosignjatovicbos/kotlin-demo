package net.czweb.games.codenames.frontend.contexts

import net.czweb.games.codenames.frontend.components.AppState
import react.createContext

val defaultState = object : AppState {
    override var infoFromServer: String = ""
    override var connected: Boolean = false
    override var connections: MutableList<String> = mutableListOf()

}

val appContext = createContext(defaultState)