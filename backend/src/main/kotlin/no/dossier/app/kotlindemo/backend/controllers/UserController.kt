package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping(RestEndpoint.Urls.GET_USER)
    fun getUser(@PathVariable userId: String): User {
        return User("Heino", "Kramm")
    }

}