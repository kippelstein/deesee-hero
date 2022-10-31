plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.spring") version "1.7.0"
    id("org.jmailen.kotlinter") version "3.11.1"
}

allprojects  {
    group = "com.company.poc"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
