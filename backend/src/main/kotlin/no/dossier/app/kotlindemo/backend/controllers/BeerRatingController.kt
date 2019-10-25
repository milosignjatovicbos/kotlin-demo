package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.domain.BeerRatingDTO
import no.dossier.app.kotlindemo.domain.BeerRatingPostRequestDTO
import no.dossier.app.kotlindemo.domain.BeerRatingsDTO
import no.dossier.app.kotlindemo.domain.BeerRatingsPostResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BeerRatingController {

    @PostMapping(RestEndpoint.Urls.BEER_RATINGS)
    @ResponseStatus(HttpStatus.CREATED)
    fun postBeerRating(@RequestBody body: BeerRatingPostRequestDTO): BeerRatingsPostResponseDTO {
        return BeerRatingsPostResponseDTO(26531)
    }

    @GetMapping(RestEndpoint.Urls.BEER_RATINGS)
    fun getBeerRatings(): BeerRatingsDTO {
        return BeerRatingsDTO(arrayOf(
                BeerRatingDTO(1, 0, 0, 2),
                BeerRatingDTO(3, 4, 5, 4)))
    }

}