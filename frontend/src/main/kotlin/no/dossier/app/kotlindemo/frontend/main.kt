package no.dossier.app.kotlindemo.frontend

import kotlinext.js.*
import no.dossier.app.kotlindemo.frontend.components.app
import react.dom.*
import kotlin.browser.*

fun main() {
    requireAll(require.context(".", true, js("/\\.css$/")))

    render(document.getElementById("viewport")) {
        app()
    }
}