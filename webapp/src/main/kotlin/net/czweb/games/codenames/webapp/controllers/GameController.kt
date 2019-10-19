package net.czweb.games.codenames.webapp.controllers

import net.czweb.games.codenames.model.Card
import net.czweb.games.codenames.webapp.ExampleJava
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/games")
class GamesController {

    @GetMapping
    fun findAll(): String {
        val card = ExampleJava(Card("black", "Sun")).card
        return card.toString()
    }

}