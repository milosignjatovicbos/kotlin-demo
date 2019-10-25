package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.domain.ResourceNotFoundException
import no.dossier.app.kotlindemo.backend.repository.UserRepository
import no.dossier.app.kotlindemo.domain.UserDTO
import no.dossier.app.kotlindemo.domain.UsersDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
class UserController @Autowired constructor(
        private val userRepository: UserRepository
) {

    @GetMapping(RestEndpoint.Urls.USER)
    fun getUserById(@PathVariable userId: Int): UserDTO = userRepository.getUserById(userId) ?: throw ResourceNotFoundException()

    @GetMapping(RestEndpoint.Urls.USERS)
    fun getUsers(@RequestParam("username") username: String?): UsersDTO = userRepository.getUsers(username)

}