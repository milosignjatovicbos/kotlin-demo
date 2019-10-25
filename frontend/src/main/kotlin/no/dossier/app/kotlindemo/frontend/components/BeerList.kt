package no.dossier.app.kotlindemo.frontend.components

import kotlinext.js.asJsObject
import react.*
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import react.dom.*
import kotlin.js.Promise

class BeerList : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        appContext.Consumer { state ->
            div {
                div {
                    state.fetchedBeers?.forEach {
                        div {
                            img {
                                attrs {
                                    src = it.image_url
                                    alt = it.name
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.beerList() = child(BeerList::class) {}