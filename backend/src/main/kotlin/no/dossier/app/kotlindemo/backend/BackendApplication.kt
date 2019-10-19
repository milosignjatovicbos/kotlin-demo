package no.dossier.app.kotlindemo.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
	SpringApplicationBuilder(BackendApplication::class.java)
		.properties("logging.level.org.springframework.web=DEBUG")
		.properties("management.endpoints.web.exposure.include=env,beans,info,health")
		.properties("spring.main.allow-bean-definition-overriding=true")
		.run(*args)
}
