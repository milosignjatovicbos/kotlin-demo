import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

group = Project.groupName
version = Project.version

plugins {
    kotlin("js")
}

repositories {
    mavenCentral()
    maven { url = uri(Repositories.kotlin_kotlinDev) }
    maven { url = uri(Repositories.kotlin_kotlinx) }
    maven { url = uri(Repositories.kotlinx_kotlinx) }
    maven { url = uri(Repositories.kotlinx_kotlinJsWrappers) }
}

kotlin {
    target {
        compilations["main"].kotlinOptions {
            sourceMap = true
            moduleKind = "commonjs"
            metaInfo = true
        }
        browser {
            runTask {
                devServer = KotlinWebpackConfig.DevServer(
                        contentBase = listOf( project.buildDir.path + "/distributions",
                                project.projectDir.path+ "/src/main/resources"),
                        proxy = mapOf("*" to "http://localhost:8080"),
                        port = 8090)
                dependsOn("browserWebpack")
            }
        }
    }

    tasks {
        val browserWebpack by getting {
            outputs.upToDateWhen { false }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(project(Modules.common))
                implementation(kotlin("stdlib-js"))
                implementation(npm("core-js", Versions.core_js))
                implementation(npm("react", Versions.react))
                implementation(npm("react-dom", Versions.react))
                compileOnly(Dependencies.kotlin_react)
                compileOnly(Dependencies.kotlin_react_dom)
                implementation(Dependencies.kotlinx_serialization_runtime_js)
            }
        }
    }
}