package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.client.BeerClient
import no.dossier.app.kotlindemo.domain.BeersDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class BeerController @Autowired constructor(private val beerClient: BeerClient) {

    @GetMapping(RestEndpoint.Urls.BEERS)
    fun getBeerRatings(): BeersDTO {
        return BeersDTO(beerClient.getBeers().toTypedArray())
    }

}