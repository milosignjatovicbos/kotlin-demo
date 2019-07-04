package no.dossier.application.archetype

import net.czweb.games.codenames.enums.*
import net.czweb.games.codenames.model.User
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class UserController {

    private val users: MutableMap<String, User> = mutableMapOf()

    @MessageMapping(EndpointUrls.GET_USERS)
    @SendTo(TopicUrls.USER_INFO)
    @Throws(Exception::class)
    fun updateUser(user: User, @DestinationVariable canvasId: Int): List<User> {
        users[user.id] = user
        return users.values.toList()
    }


}