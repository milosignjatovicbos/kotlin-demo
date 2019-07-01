group = "net.czweb.games.code-names"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("multiplatform") version "1.3.31" apply false
    kotlin("jvm") version "1.3.31" apply false
    id("kotlin2js") version "1.3.31" apply false
    id("org.jetbrains.kotlin.frontend") apply false
}

tasks {
   /* register<Copy>("copyJsArtifacts", Copy::class) {

        from("common/build/classes/kotlin/js/main") {
            include("common.js")
        }
        into("frontend/build/classes/kotlin/main")

        dependsOn(":common:assemble", ":frontend:compileKotlin2Js")
    }*/
    register<Copy>("copyFeResources", Copy::class) {

        from("frontend/build/bundle") {
            include("dev.bundle.js")
        }

        from("frontend/src/main/resources") {
            include("*")
        }

        into("webapp/src/main/resources/static")

        dependsOn(":frontend:assemble")
    }
}
