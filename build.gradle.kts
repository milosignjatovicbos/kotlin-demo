group = Project.groupName
version = Project.version

plugins {
    kotlin("multiplatform") version Versions.kotlin apply false
    kotlin("jvm") version Versions.kotlin apply false
    kotlin("js") version Versions.kotlin apply false
    kotlin("plugin.spring") version Versions.kotlin apply false
    id("kotlinx-serialization") version Versions.kotlin apply false
    id("org.springframework.boot") version Versions.spring apply false
    id("io.spring.dependency-management") version Versions.spring_dependency_management apply false
}