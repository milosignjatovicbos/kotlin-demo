package no.dossier.app.kotlindemo.frontend.contexts

import no.dossier.app.kotlindemo.domain.Beer
import no.dossier.app.kotlindemo.frontend.components.AppState
import no.dossier.app.kotlindemo.domain.User
import react.createContext
import kotlin.js.Promise

val defaultState = object : AppState {
    override var fetchedBeers: List<Beer>? = listOf()
    override var sendChatMessage: (String) -> Unit = { }
    override var fetchedUser: User? = null
    override var connected: Boolean = false
    override var connections: MutableList<String> = mutableListOf()
    override var chatContent: String = ""
}

val appContext = createContext(defaultState)