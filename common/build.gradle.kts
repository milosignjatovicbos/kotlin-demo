group = Project.groupName
version = Project.version

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

repositories {
    mavenCentral()
    maven { url = uri(Repositories.kotlin_kotlinx) }
}

kotlin {
    jvm()
    js {
        compilations["main"].kotlinOptions {
            sourceMap = true
            moduleKind = "commonjs"
            metaInfo = true
        }
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Dependencies.kotlinx_serialization_runtime_common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Dependencies.kotlinx_serialization_runtime_jvm)
                implementation(kotlin("stdlib-jdk8"))
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(Dependencies.kotlinx_serialization_runtime_js)
                implementation(kotlin("stdlib-js"))
            }
        }

        val jsTest by getting
    }
}
