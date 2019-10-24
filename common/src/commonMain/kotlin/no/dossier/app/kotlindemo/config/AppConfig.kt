package no.dossier.app.kotlindemo.config

object AppConfig {
    val MessageBrokerDestinationPrefixes = arrayOf("/topic", "/queue")
    const val ApplicationDestinationPrefix = "/app"
    const val WebSocketEndpoint = "/websocket"
}