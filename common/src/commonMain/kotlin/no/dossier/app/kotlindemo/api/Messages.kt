package no.dossier.app.kotlindemo.api

import kotlinx.serialization.Serializable

enum class EventType {
    NewConnection,
    ConnectionClosed
}

@Serializable
sealed class Message {
    val messageType = this::class.simpleName

    @Serializable class ConnectionUpdated(val connectionId: String, val eventType: EventType) : Message()
}
