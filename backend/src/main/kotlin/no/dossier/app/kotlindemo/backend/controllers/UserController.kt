package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.domain.ResourceNotFoundException
import no.dossier.app.kotlindemo.domain.UserDTO
import no.dossier.app.kotlindemo.domain.UsersDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    private val users = mapOf(
            Pair(1, UserDTO(1, "Heino", "Kramm", "heino")),
            Pair(2, UserDTO(2, "Mihajlo", "Jovanovic", "mihajlo")),
            Pair(3, UserDTO(3, "Milos", "Ignjatovic", "milos")),
            Pair(4, UserDTO(4, "Roy", "Brokvam", "roy")))

    @GetMapping(RestEndpoint.Urls.USER)
    fun getUser(@PathVariable userId: Int): UserDTO {
        return users[userId] ?: throw ResourceNotFoundException()
    }

    @GetMapping(RestEndpoint.Urls.USERS)
    fun getUsers(): UsersDTO {
        return UsersDTO(users.values.toTypedArray())
    }

}