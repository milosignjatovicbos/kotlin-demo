package no.dossier.app.kotlindemo.backend.repository

import no.dossier.app.kotlindemo.domain.UserDTO
import no.dossier.app.kotlindemo.domain.UsersDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class UserRepository @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {

    fun getUserById(userId: Int): UserDTO? {
        return jdbcTemplate.query(
                "SELECT user_id, user_first_name, user_surname, user_username FROM beer_users WHERE user_id = ?",
                arrayOf<Any>(userId),
                ResultSetExtractor { return@ResultSetExtractor if (it.next()) extractUser(it) else null });
    }

    fun getUsers(): UsersDTO {
        val users = jdbcTemplate.query("SELECT user_id, user_first_name, user_surname, user_username FROM beer_users") { rs, _ -> extractUser(rs) }
        return UsersDTO(users.toTypedArray());
    }

    fun extractUser(rs: ResultSet): UserDTO {
        val userId: Int = rs.getInt(1)
        val firstName: String = rs.getString(2)
        val surname: String = rs.getString(3)
        val username: String = rs.getString(4)
        return UserDTO(userId, firstName, surname, username)
    }

}