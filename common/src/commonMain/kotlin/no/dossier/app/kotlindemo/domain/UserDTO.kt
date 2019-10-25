package no.dossier.app.kotlindemo.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(val userId: Int, val firstName: String, val surname: String, val username: String)