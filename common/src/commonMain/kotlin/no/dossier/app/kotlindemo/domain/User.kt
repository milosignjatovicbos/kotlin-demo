package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable
import no.dossier.app.kotlindemo.utils.getPlatformName

@Serializable
data class User(val name: String, val surname: String, val createdOn: String = getPlatformName()) {

    val formattedName: String
        get() = "$name $surname (created on $createdOn platform)"
}