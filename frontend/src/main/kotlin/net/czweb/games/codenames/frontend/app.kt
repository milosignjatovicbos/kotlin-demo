package net.czweb.games.codenames.frontend

import net.czweb.games.codenames.enums.Topic
import net.czweb.games.codenames.model.Card
import net.czweb.games.codenames.model.User
import react.*
import react.dom.h1
import react.dom.h2
import kotlin.browser.window
import kotlinx.serialization.json.*
import kotlinx.serialization.*
import wrappers.*

interface AppState: RState {
    var infoFromServer: String
    var connected: Boolean
    var connectedUsers: List<User>
}

class App : RComponent<RProps, AppState>() {

    val websocketEndpoint: String = "http://" + window.location.host.split(':')[0] + ":8080/websocket"

    private var stompClient: Stomp
    private val connectionId = generateID(20)

    init {
        stompClient = connect()
    }

    fun generateID(size: Int): String {
        val source = "A1BCDEF4G0H8IJKLM7NOPQ3RST9UVWX52YZab1cd60ef2ghij3klmn49opq5rst6uvw7xyz8"
        return (source).map { it }.shuffled().subList(0, size).joinToString("")
    }

    private fun connect(): Stomp {
        val socket = SockJS(websocketEndpoint)
        val stompClient = Stomp.over(socket)
        stompClient.connect(StompConfig(connectionId)) {
            setState {
                connected = true
            }
            stompClient.subscribe(Topic.UserInfo.value) { data ->
                setState {
                    connectedUsers = Json.parse(User.serializer().list, data.body)
                    console.log(connectedUsers)
                }
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
        window.fetch("games").then {
            it.text()
        }.then {
            setState {
                infoFromServer = it
            }
        }
    }

    override fun RBuilder.render() {
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
    }
}

fun RBuilder.app() = child(App::class) {}
