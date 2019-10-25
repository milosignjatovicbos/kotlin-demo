package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable
import no.dossier.app.kotlindemo.utils.getPlatformName

@Serializable
data class BeerRatingsGetResponseDTO(val ratingId: Int)