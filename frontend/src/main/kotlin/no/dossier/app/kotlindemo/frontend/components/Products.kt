package no.dossier.app.kotlindemo.frontend.components

import react.*
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import no.dossier.app.kotlindemo.domain.DossierApplication
import react.dom.*

@Suppress("UnsafeCastFromDynamic")
class Product : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        appContext.Consumer { appState ->
            div {
                val product = appState.product
                if (product != null) {
                    img {
                        attrs.src = when (product) {
                            is DossierApplication.DossierProFile -> "proFile.png"
                            is DossierApplication.DossierProFileDM -> "proFileDM.png"
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.product() = child(Product::class) {}
