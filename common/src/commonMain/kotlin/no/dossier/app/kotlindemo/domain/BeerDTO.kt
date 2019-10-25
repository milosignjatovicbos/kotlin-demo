package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable

@Serializable
data class BeerDTO(val id: Int, val name: String, val tagline: String, val image_url: String)