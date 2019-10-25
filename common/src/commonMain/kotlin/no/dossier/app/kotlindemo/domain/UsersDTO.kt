package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable

@Serializable
data class UsersDTO(val users: Array<UserDTO>)