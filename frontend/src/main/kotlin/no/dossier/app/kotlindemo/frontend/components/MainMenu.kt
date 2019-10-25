package no.dossier.app.kotlindemo.frontend.components

import react.*
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import react.dom.*

class MainMenu : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        appContext.Consumer{ state ->
            div {
                div {
                    +"Home | BearDetails"
                    }
                }

        }
    }
}

fun RBuilder.mainMenu() = child(MainMenu::class) {}