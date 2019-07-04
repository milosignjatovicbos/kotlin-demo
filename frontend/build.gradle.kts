plugins {
    kotlin("js")
}

group = "net.czweb.games.code-names"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-dev") }
    maven { url = uri("http://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("http://dl.bintray.com/kotlinx/kotlinx") }
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

kotlin {
    target {
        compilations["main"].kotlinOptions {
            sourceMap = true
            moduleKind = "commonjs"
            metaInfo = true
        }
        browser {

        }
    }

    sourceSets["main"].dependencies {
        implementation(project(":common"))
        implementation(kotlin("stdlib-js"))
        implementation(npm("core-js", "3.1.1"))
        implementation(npm("react", "^16.6.0"))
        implementation(npm("react-dom", "^16.6.0"))
        compileOnly( "org.jetbrains:kotlin-react:16.6.0-pre.73-kotlin-1.3.40")
        compileOnly( "org.jetbrains:kotlin-react-dom:16.6.0-pre.73-kotlin-1.3.40")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.11.1")
    }
}