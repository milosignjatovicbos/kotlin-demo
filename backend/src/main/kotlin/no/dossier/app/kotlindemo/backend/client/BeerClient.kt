package no.dossier.app.kotlindemo.backend.client

import no.dossier.app.kotlindemo.domain.BeerDTO
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BeerClient {

    private val client = RestTemplate()

    fun getBeers(): List<BeerDTO> {
        val x0 = client.exchange("https://api.punkapi.com/v2/beers", HttpMethod.GET, null, object : ParameterizedTypeReference<Any>() {})
        val x1 = client.exchange("https://api.punkapi.com/v2/beers", HttpMethod.GET, null, object : ParameterizedTypeReference<List<BeerDTO>>() {})
        val x2 = x1.body
        return x2 as List<BeerDTO>
    }

}