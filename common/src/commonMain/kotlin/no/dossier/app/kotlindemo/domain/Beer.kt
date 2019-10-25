package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable

@Serializable
data class Beer(
        val id: Int,
        val name: String,
        val tagline: String,
        val first_brewed: String,
        val description: String,
        val image_url: String
)