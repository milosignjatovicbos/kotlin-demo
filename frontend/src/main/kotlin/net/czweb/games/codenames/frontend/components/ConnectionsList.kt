package net.czweb.games.codenames.frontend

import react.*
import net.czweb.games.codenames.frontend.contexts.appContext
import react.dom.*

class ConnectionsList : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        appContext.Consumer { state ->
            div {
                ul {
                    state.connections.forEach {
                        li {
                            +it
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.connectionsList() = child(ConnectionsList::class) {}
