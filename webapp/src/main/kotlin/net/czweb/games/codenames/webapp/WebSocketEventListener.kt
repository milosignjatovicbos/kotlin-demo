package net.czweb.games.codenames.webapp

import net.czweb.games.codenames.api.EventType
import net.czweb.games.codenames.api.Message
import net.czweb.games.codenames.enums.Endpoint
import net.czweb.games.codenames.enums.Topic
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessageHeaderAccessor.getUser
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event
import org.springframework.web.socket.messaging.AbstractSubProtocolEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent


@Component
private class WebSocketEventListener {

    @Autowired
    private lateinit var template: SimpMessagingTemplate

    @EventListener
    fun handleSessionConnected(event: SessionConnectEvent) = with(Registry.connections) {
        val sessionId = StompHeaderAccessor.wrap(event.message).sessionId!!
        add(sessionId)
        template.convertAndSend(Topic.UserInfo.value, Message.ConnectionUpdated(sessionId, EventType.NewConnection))
    }

    @EventListener
    fun handleSessionDisconnected(event: SessionDisconnectEvent) = with(Registry.connections) {
        val sessionId = StompHeaderAccessor.wrap(event.message).sessionId!!
        remove(sessionId)
        template.convertAndSend(Topic.UserInfo.value, Message.ConnectionUpdated(sessionId, EventType.ConnectionClosed))
    }
}