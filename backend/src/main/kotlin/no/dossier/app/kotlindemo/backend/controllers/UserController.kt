package no.dossier.app.kotlindemo.backend.controllers

import no.dossier.app.kotlindemo.api.RestEndpoint
import no.dossier.app.kotlindemo.backend.domain.ResourceNotFoundException
import no.dossier.app.kotlindemo.backend.repository.UserRepository
import no.dossier.app.kotlindemo.domain.UserDTO
import no.dossier.app.kotlindemo.domain.UsersDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController @Autowired constructor(
        private val userRepository: UserRepository
) {

    @GetMapping(RestEndpoint.Urls.USER)
    fun getUser(@PathVariable userId: Int): UserDTO = userRepository.getUserById(userId) ?: throw ResourceNotFoundException()

    @GetMapping(RestEndpoint.Urls.USERS)
    fun getUsers(): UsersDTO = userRepository.getUsers()

}