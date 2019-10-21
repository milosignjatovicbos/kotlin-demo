package no.dossier.app.kotlindemo.frontend.components

import kotlinext.js.js
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onKeyPressFunction
import kotlinx.html.style
import react.*
import no.dossier.app.kotlindemo.frontend.contexts.appContext
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.KeyboardEvent
import react.dom.*

interface ChatState: RState {
    var msgInputValue: String
}

@Suppress("UnsafeCastFromDynamic")
class Chat : RComponent<RProps, ChatState>() {

    init {
        state.msgInputValue = ""
    }

    fun sendMsg(appState: AppState) {
        appState.sendChatMessage(state.msgInputValue)
        setState {
            msgInputValue = ""
        }
    }

    override fun RBuilder.render() {
        appContext.Consumer { appState ->
            div {
                textArea {
                    attrs {
                        value = appState.chatContent
                        readonly = true
                        style = js {
                            width = "700px"
                            height = "200px"
                            display = "block"
                        }
                    }
                }
                input(type = InputType.text, name = "msgInput") {
                    attrs {
                        value = state.msgInputValue
                        onChangeFunction = {
                            val newValue = (it.target as HTMLInputElement).value
                            setState {
                                msgInputValue = newValue
                            }
                        }
                        onKeyPressFunction = {
                            if (it.asDynamic().key == "Enter") {
                                sendMsg(appState)
                            }
                        }
                        style = js {
                            this.width = "600px"
                        }
                    }
                }
                button {
                    attrs.onClickFunction = { sendMsg(appState) }
                    +"Send"
                }
            }
        }
    }
}

fun RBuilder.chat() = child(Chat::class) {}
