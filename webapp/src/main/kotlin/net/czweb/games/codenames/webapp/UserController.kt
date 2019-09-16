package net.czweb.games.codenames.webapp

import net.czweb.games.codenames.enums.*
import net.czweb.games.codenames.model.User
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller

@Controller
class UserController {

    private val users: MutableMap<String, User> = mutableMapOf()

    @SubscribeMapping(EndpointUrls.GET_USERS)
    //@SendTo(TopicUrls.USER_INFO)
    @Throws(Exception::class)
    fun updateUser(@DestinationVariable userId: String): List<User> {
        users[userId] = User(userId)
        return users.values.toList()
    }


}