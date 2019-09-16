package wrappers

class StompConfig(val user: String, val passcode: String? = null)
fun getDefaultStompConfig(): StompConfig = js("{}")

external class Frame {
    val body: String
}
class SendOptions
fun getDefaultSendOptions(): SendOptions = js("{}")

external class Stomp {
    companion object {
        fun over(socket: SockJS): Stomp
    }

    fun connect(config : StompConfig, onConnected: (Frame) -> Unit)
    fun subscribe(channel : String, onReceive: (Frame) -> Unit)
    fun disconnect()
    fun send(channel: String, options: SendOptions, data: String)

}