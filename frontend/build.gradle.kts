import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    kotlin("js")
}

group = "net.czweb.games.code-names"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-dev") }
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
    }
}

/*dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.4")
    implementation( "org.jetbrains:kotlin-react:16.6.0-pre.73-kotlin-1.3.40")
    implementation( "org.jetbrains:kotlin-react-dom:16.6.0-pre.73-kotlin-1.3.40")
}*/

/*kotlinFrontend {
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
        pat
    }
}*/

tasks {
   /* "compileKotlin2Js"(Kotlin2JsCompile::class) {
        kotlinOptions {
            moduleKind = "commonjs"
            metaInfo = true
            sourceMap = true
            sourceMapEmbedSources = "always"
            outputFile = "build/classes/kotlin/main/index.js"
            main = "call"
        }

    }*/
  /*  task<YarnTask>("ngBuild") {
        dependsOn("yarn_install", "jar2npm")

        inputs.files(fileTree("node_modules"))
        inputs.files(fileTree("src"))
        inputs.file("package.json")

        outputs.dir("dist")

        args = listOf("run", "build")
    }

    withType<Jar> {
        dependsOn("ngBuild")
    }*/

  /*  "clean" {
        doLast {
            println("Delete dist and node_modules")
            file("$projectDir/dist").deleteRecursively()
            file("$projectDir/node_modules").deleteRecursively()
        }
    }*/
}