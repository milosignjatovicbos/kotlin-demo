package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.EndpointUrls
import no.dossier.app.kotlindemo.backend.ExampleJavaWrapper
import no.dossier.app.kotlindemo.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping(EndpointUrls.GET_USER)
    fun getUser(@PathVariable userId: String): User {
        return ExampleJavaWrapper(User("Heino", "Kramm")).user
    }

}