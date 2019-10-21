package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.ApplicationRegistry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ConnectionController {

    @GetMapping(RestEndpoint.Urls.GET_ALL_CONNECTIONS)
    fun getAllConnections(): List<String> {
        return ApplicationRegistry.connections
    }

}