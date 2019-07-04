pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/snapshot") }
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
		gradlePluginPortal()
	}
	resolutionStrategy {
		eachPlugin {
			when (requested.id.id) {
				"org.springframework.boot" -> useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
				"kotlinx-serialization" -> useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
			}
		}
	}
}
rootProject.name = "code-names"
include(
		":common",
		":frontend",
		":webapp"
)