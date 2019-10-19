package net.czweb.games.codenames.webapp.controllers

import net.czweb.games.codenames.enums.*
import net.czweb.games.codenames.model.User
import net.czweb.games.codenames.webapp.Registry
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller

@Controller
class ConnectionController {

    @MessageMapping(Topic.Urls.USER_INFO)
    fun updateUser(@DestinationVariable sessionId: String): List<String> {
        return Registry.connections
    }


}