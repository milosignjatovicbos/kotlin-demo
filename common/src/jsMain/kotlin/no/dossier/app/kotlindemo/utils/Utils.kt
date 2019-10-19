package no.dossier.app.kotlindemo.utils

import no.dossier.app.kotlindemo.model.User

actual fun getPlatformName(): String = "js"

fun User.toHtml():String {
    return ""
}