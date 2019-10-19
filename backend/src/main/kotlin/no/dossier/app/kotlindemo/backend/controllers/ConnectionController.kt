package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.EndpointUrls
import no.dossier.app.kotlindemo.api.Topic
import no.dossier.app.kotlindemo.backend.ApplicationRegistry
import no.dossier.app.kotlindemo.backend.ExampleJavaWrapper
import no.dossier.app.kotlindemo.model.User
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ConnectionController {

    @MessageMapping(Topic.Urls.USER_INFO)
    fun updateUser(@DestinationVariable sessionId: String): List<String> {
        return ApplicationRegistry.connections
    }

    @GetMapping(EndpointUrls.GET_ALL_CONNECTIONS)
    fun getAllConnections(): List<String> {
        return ApplicationRegistry.connections
    }
}