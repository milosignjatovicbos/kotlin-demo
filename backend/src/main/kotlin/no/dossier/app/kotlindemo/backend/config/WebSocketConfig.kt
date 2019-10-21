package no.dossier.app.kotlindemo.backend.config

import no.dossier.app.kotlindemo.config.AppConfig
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.enableSimpleBroker(*AppConfig.MessageBrokerDestinationPrefixes)
        config.setApplicationDestinationPrefixes(AppConfig.ApplicationDestinationPrefix)
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint(AppConfig.WebSocketEndpoint).setAllowedOrigins("*").withSockJS()
    }

}
