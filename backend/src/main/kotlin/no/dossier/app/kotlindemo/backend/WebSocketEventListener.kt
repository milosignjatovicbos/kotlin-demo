package no.dossier.app.kotlindemo.backend

import no.dossier.app.kotlindemo.api.EventType
import no.dossier.app.kotlindemo.api.Message
import no.dossier.app.kotlindemo.api.Topic
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.web.socket.messaging.SessionDisconnectEvent


@Component
private class WebSocketEventListener {

    @Autowired
    private lateinit var template: SimpMessagingTemplate

    @EventListener
    fun handleSessionConnected(event: SessionConnectEvent) = with(ApplicationRegistry.connections) {
        val sessionId = StompHeaderAccessor.wrap(event.message).sessionId!!
        add(sessionId)
        template.convertAndSend(Topic.UserInfo.value, Message.ConnectionUpdated(sessionId, EventType.NewConnection))
    }

    @EventListener
    fun handleSessionDisconnected(event: SessionDisconnectEvent) = with(ApplicationRegistry.connections) {
        val sessionId = StompHeaderAccessor.wrap(event.message).sessionId!!
        remove(sessionId)
        template.convertAndSend(Topic.UserInfo.value, Message.ConnectionUpdated(sessionId, EventType.ConnectionClosed))
    }
}