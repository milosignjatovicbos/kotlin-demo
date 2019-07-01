group = "net.czweb.games.code-names"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("multiplatform") version "1.3.40" apply false
    kotlin("jvm") version "1.3.40" apply false
    kotlin("js") version "1.3.40" apply false
}

tasks {
    register<Copy>("copyFeResources", Copy::class) {

        from("frontend/build/libs") {
            include("*.js")
        }

        from("frontend/src/main/resources") {
            include("*")
        }

        into("webapp/src/main/resources/static")

        dependsOn(":frontend:browserWebpack")
    }
}
