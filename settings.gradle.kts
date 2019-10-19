pluginManagement {
	repositories {
		maven { url = uri(Repositories.spring_snapshot) }
		maven { url = uri(Repositories.spring_milestone) }
		maven { url = uri(Repositories.kotlin_eap) }
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
rootProject.name = Project.name

include(Modules.common,
		Modules.frontend,
		Modules.backend)