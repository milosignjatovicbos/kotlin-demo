package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable
import no.dossier.app.kotlindemo.utils.getPlatformName

@Serializable
data class BeerRatingDTO(val ratingId: Int, val beerId: Int, val userId: Int, val rating: Int)