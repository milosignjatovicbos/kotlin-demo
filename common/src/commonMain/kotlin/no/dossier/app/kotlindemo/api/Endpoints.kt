package no.dossier.app.kotlindemo.api

enum class Topic(val value: String) {
    UserInfo(Urls.USER_INFO);

    class Urls {
        companion object {
            const val USER_INFO = "/topic/userinfo"
        }
    }
}

class EndpointUrls {
    companion object {
        const val GET_USER = "/users/{userId}"
        const val GET_ALL_CONNECTIONS = "/connections/all"
    }
}

enum class Endpoint(val value: String) {
    GetUser(EndpointUrls.GET_USER),
    GetAllConnections(EndpointUrls.GET_ALL_CONNECTIONS);
}