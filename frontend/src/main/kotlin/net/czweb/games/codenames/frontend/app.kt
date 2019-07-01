package net.czweb.games.codenames.frontend

import net.czweb.games.codenames.model.Card
import net.czweb.games.codenames.model.toHtml
import react.*
import react.dom.h1
import react.dom.h2
import kotlin.browser.window

interface AppState: RState {
    var infoFromServer: String
}

class App : RComponent<RProps, AppState>() {

    override fun componentDidMount() {
        window.fetch("games").then {
            it.text()
        }.then {
            setState {
                infoFromServer = it
            }
        }
    }

    override fun RBuilder.render() {
        val card = Card("blue", "Moon")

        h1 {
            +"Kotlin"
        }
        h2 {
            +"Card instance used on FE: $card"
        }
        h2 {
            +"Card instance used on BE: ${state.infoFromServer}"
        }
    }
}

fun RBuilder.app() = child(App::class) {}
