package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable

@Serializable
data class BeersDTO(val beers:Array<BeerDTO>)