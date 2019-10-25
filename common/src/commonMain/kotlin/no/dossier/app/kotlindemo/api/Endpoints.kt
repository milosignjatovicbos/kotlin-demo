package no.dossier.app.kotlindemo.api

import no.dossier.app.kotlindemo.config.AppConfig

enum class Topic(val value: String) {
    UserInfo(Urls.USER_INFO),
    Chat(Urls.CHAT);

    class Urls {
        companion object {
            const val USER_INFO = "/topic/userinfo"
            const val CHAT = "/topic/chat"
        }
    }
}

enum class WsEndpoint(val value: String) {
    SendChatMessage(Urls.SEND_CHAT_MESSAGE);

    class Urls {
        companion object {
            const val SEND_CHAT_MESSAGE = "/chat"
        }
    }

    val prefixedUrl = AppConfig.ApplicationDestinationPrefix + value
}

enum class RestEndpoint(val value: String) {
    GetDemoUser(Urls.GET_DEMO_USER),
    GetAllConnections(Urls.GET_ALL_CONNECTIONS),
    Users(Urls.USERS),
    User(Urls.USER),
    BeerRatings(Urls.BEER_RATINGS),
    GetAllBeers(Urls.GET_ALL_BEERS);

    class Urls {
        companion object {
            const val GET_DEMO_USER = "/demo-users/{userId}"
            const val GET_ALL_CONNECTIONS = "/connections/all"
            const val USERS = "/users"
            const val USER = "/users/{userId}"
            const val BEER_RATINGS = "/beer-ratings"
            const val GET_ALL_BEERS = "https://api.punkapi.com/v2/beers?brewed_before=11-2012&abv_gt=6"
        }
    }
}