import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.KOTLIN
}

group = Metadata.GROUP
version = Versions.NEWANDLIB

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = Versions.JAVA

            @Suppress("SpellCheckingInspection")
            freeCompilerArgs = listOf("-Xcontext-receivers")
        }
    }

    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation("com.google.guava:guava:${Versions.GUAVA}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}")

    testImplementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLINX_COROUTINES}"
    )
}
