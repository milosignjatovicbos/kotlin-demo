package net.czweb.games.codenames.frontend

import kotlinext.js.*
import react.dom.*
import kotlin.browser.*

fun main() {
    requireAll(require.context(".", true, js("/\\.css$/")))

    render(document.getElementById("viewport")) {
        app()
    }
}