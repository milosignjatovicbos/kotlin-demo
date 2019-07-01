import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("kotlin2js")
    id("org.jetbrains.kotlin.frontend")
}

group = "net.czweb.games.code-names"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-dev") }
    maven { url = uri("http://dl.bintray.com/kotlinx/kotlinx") }
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.4")
    implementation( "org.jetbrains:kotlin-react:16.6.0-pre.71-kotlin-1.3.31")
    implementation( "org.jetbrains:kotlin-react-dom:16.6.0-pre.71-kotlin-1.3.31")
}

kotlinFrontend {
    downloadNodeJsVersion = "12.2.0"
    npm {
        dependency("react", "16.6.0")
        dependency("core-js", "3.1.1")
        dependency("react-dom", "16.6.0")
    }
    sourceMaps = true
    bundle<WebPackExtension>("webpack") {
        this as WebPackExtension
        bundleName = "dev"
        mode = "development"
        contentPath = file("src/main/resources")
    }
}

tasks {
    "compileKotlin2Js"(Kotlin2JsCompile::class) {
        kotlinOptions {
            moduleKind = "commonjs"
            metaInfo = true
            sourceMap = true
//            sourceMapEmbedSources = "always"
//            outputFile = "build/classes/kotlin/main/index.js"
            main = "call"
        }

    }
    "processResources" {
        dependsOn(":copyJsArtifacts")
    }
}