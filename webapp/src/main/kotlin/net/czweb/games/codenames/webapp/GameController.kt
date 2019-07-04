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

    @GetMapping
    fun generateID(size: Int): String {
        val source = "A1BCDEF4G0H8IJKLM7NOPQ3RST9UVWX52YZab1cd60ef2ghij3klmn49opq5rst6uvw7xyz8"
        return (source).map { it }.shuffled().subList(0, size).joinToString("")
    }

}