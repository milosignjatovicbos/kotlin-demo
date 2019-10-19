package net.czweb.games.codenames.enums

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
        const val UPDATE_USER = "/updateuser/{userId}"
    }
}

enum class Endpoint(val value: String) {
    UpdateUser(EndpointUrls.UPDATE_USER);
}