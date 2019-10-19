package net.czweb.games.codenames.frontend.components

import net.czweb.games.codenames.enums.Topic
import net.czweb.games.codenames.model.Card
import react.*
import react.dom.h1
import react.dom.h2
import kotlin.browser.window
import kotlinx.serialization.json.*
import net.czweb.games.codenames.api.EventType
import net.czweb.games.codenames.api.Message
import net.czweb.games.codenames.frontend.connectionsList
import net.czweb.games.codenames.frontend.contexts.appContext
import wrappers.*

interface AppState: RState {
    var infoFromServer: String
    var connected: Boolean
    var connections: MutableList<String>
}

class App : RComponent<RProps, AppState>() {

    val websocketEndpoint: String = "http://" + window.location.host.split(':')[0] + ":8080/websocket"

    private var stompClient: Stomp = connect()

    init {
        state.connections = mutableListOf()
    }

    private fun connect(): Stomp {
        val socket = SockJS(websocketEndpoint)
        val stompClient = Stomp.over(socket)
        stompClient.connect(StompConfig()) {
            setState {
                connected = true
            }
            stompClient.subscribe(Topic.UserInfo.value) { data ->
                setState {
                    val message = Json.parse(Message.ConnectionUpdated.serializer(), data.body)
                    when (message.eventType) {
                        EventType.NewConnection -> connections.add(message.connectionId)
                        EventType.ConnectionClosed -> connections.remove(message.connectionId)
                    }

                    console.log(message)

                }
            }
            /*stompClient.send(Endpoint.UpdateUser.value.replace("{userId}", connectionId),
                    getDefaultSendOptions(),"")*/
        }
        return stompClient
    }

    private fun disconnect() {
        stompClient.disconnect()
        setState{
            connected = false
        }
    }

    override fun componentDidMount() {
        window.fetch("games").then {
            it.text()
        }.then {
            setState {
                infoFromServer = it
            }
        }
    }

    override fun RBuilder.render() {
        appContext.Provider(state) {
            val card = Card("blue", "Moon")

            h1 {
                +"Kotlin"
            }
            h2 {
                +"Card instance used on FE: $card"
            }
            h2 {
                +"Card instance used on BE: ${state.infoFromServer}"
            }
            connectionsList()
        }
    }
}

fun RBuilder.app() = child(App::class) {}
