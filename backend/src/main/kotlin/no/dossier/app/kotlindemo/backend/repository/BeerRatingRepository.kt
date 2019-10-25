package no.dossier.app.kotlindemo.backend.repository

import no.dossier.app.kotlindemo.domain.BeerRatingDTO
import no.dossier.app.kotlindemo.domain.BeerRatingPostRequestDTO
import no.dossier.app.kotlindemo.domain.BeerRatingsDTO
import no.dossier.app.kotlindemo.domain.BeerRatingsPostResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

@Repository
class BeerRatingRepository @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {

    fun createRating(rating: BeerRatingPostRequestDTO): BeerRatingsPostResponseDTO {
        val statementCreator = PreparedStatementCreator { conn ->
            val statement: PreparedStatement = conn.prepareStatement(
                    "INSERT INTO beer_rating(rating_beer_id, rating_user_id, rating_rating) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)
            statement.setInt(1, rating.beerId)
            statement.setInt(2, rating.userId)
            statement.setInt(3, rating.rating)
            statement
        }

        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(statementCreator, keyHolder)
        val ratingId = keyHolder.keys!!.get("rating_id") as Int
        return BeerRatingsPostResponseDTO(ratingId)
    }

    fun getRatings(): BeerRatingsDTO {
        val ratings = jdbcTemplate.query("SELECT rating_id, rating_beer_id, rating_user_id, rating_rating FROM beer_rating") { rs, _ -> extractRating(rs) }
        return BeerRatingsDTO(ratings.toTypedArray());
    }

    fun extractRating(rs: ResultSet): BeerRatingDTO {
        val ratingId: Int = rs.getInt(1)
        val beerId: Int = rs.getInt(2)
        val userId: Int = rs.getInt(3)
        val rating: Int = rs.getInt(4)
        return BeerRatingDTO(ratingId, beerId, userId, rating)
    }

}