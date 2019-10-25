package no.dossier.app.kotlindemo.frontend.components

import react.*
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import org.w3c.dom.HTMLDivElement
import react.dom.*
import kotlin.browser.document

class BeerList : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        appContext.Consumer { state ->
            div {
                div {
                    state.fetchedBeers?.forEach {
                        span {
                            img {
                                attrs {
                                    width = "212px"
                                    src = it.image_url
                                    alt = it.name
                                }
                            }
                            span {
                                +it.name
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.beerList() = child(BeerList::class) {}