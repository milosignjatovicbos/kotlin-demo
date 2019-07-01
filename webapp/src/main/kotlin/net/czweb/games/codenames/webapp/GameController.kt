package net.czweb.games.codenames.webapp

import net.czweb.games.codenames.model.Card
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/games")
class GamesController {

    @GetMapping
    fun findAll(): String {
        val card = Card("red", "Sun")
        return card.toString()
    }

}