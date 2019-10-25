package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.repository.BeerRatingRepository
import no.dossier.app.kotlindemo.domain.BeerRatingPostRequestDTO
import no.dossier.app.kotlindemo.domain.BeerRatingsDTO
import no.dossier.app.kotlindemo.domain.BeerRatingsPostResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
class BeerRatingController @Autowired constructor(private val beerRatingRepository: BeerRatingRepository) {

    @PostMapping(RestEndpoint.Urls.BEER_RATINGS)
    @ResponseStatus(HttpStatus.CREATED)
    fun postBeerRating(@RequestBody rating: BeerRatingPostRequestDTO): BeerRatingsPostResponseDTO = beerRatingRepository.createRating(rating)

    @GetMapping(RestEndpoint.Urls.BEER_RATINGS)
    fun getBeerRatings(): BeerRatingsDTO = beerRatingRepository.getRatings()

}