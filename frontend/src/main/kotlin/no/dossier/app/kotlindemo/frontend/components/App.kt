package no.dossier.app.kotlindemo.frontend.components

import kotlinx.serialization.ImplicitReflectionSerializer
import no.dossier.app.kotlindemo.model.User
import react.*
import react.dom.*
import kotlin.browser.window
import kotlinx.serialization.json.*
import kotlinx.serialization.list
import kotlinx.serialization.serializer
import no.dossier.app.kotlindemo.api.Endpoint
import no.dossier.app.kotlindemo.api.EventType
import no.dossier.app.kotlindemo.api.Message
import no.dossier.app.kotlindemo.api.Topic
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import no.dossier.app.kotlindemo.frontend.wrappers.*

interface AppState: RState {
    var fetchedUser: User?
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
        window.fetch(Endpoint.GetUser.value.replace("{userId}", 1.toString())).then {
            it.text()
        }.then {
            setState {
                fetchedUser = Json.nonstrict.parse(User.serializer(), it)
            }
        }
    }

    @ImplicitReflectionSerializer
    override fun componentDidUpdate(prevProps: RProps, prevState: AppState, snapshot: Any) {
        if (!prevState.connected && state.connected) {
            stompClient.subscribe(Topic.UserInfo.value) { data ->
                setState {
                    val message = Json.parse(Message.ConnectionUpdated.serializer(), data.body)
                    when (message.eventType) {
                        EventType.NewConnection -> connections.add(message.connectionId)
                        EventType.ConnectionClosed -> connections.remove(message.connectionId)
                    }
                }
            }

            window.fetch(Endpoint.GetAllConnections.value).then {
                it.text()
            }.then {
                setState {
                    connections = Json.parse(String::class.serializer().list, it).toMutableList()
                }
            }

            /*stompClient.send(Endpoint.UpdateUser.value.replace("{userId}", connectionId),
                    getDefaultSendOptions(),"")*/
        }
    }

    override fun RBuilder.render() {
        appContext.Provider(state) {
            h1 {
                +"Kotlin demo"
            }
            h3 {
                +User("Hanses", "Oddvindsen").formattedName
            }
            h3 {
                +(state.fetchedUser?.formattedName ?: "")
            }
            h3 {
                +"Active connections: "
            }
            connectionsList()
        }
    }
}

fun RBuilder.app() = child(App::class) {}
