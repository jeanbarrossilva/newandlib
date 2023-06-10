package com.jeanbarrossilva.newandlib.project.type.library.structure.app

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class BuildGradleFile(override val parentPath: Path, naming: Naming) : TextFile() {
    override val name = "build.gradle.kts"
    override val text = """
        plugins {
            id("com.android.application")
            id("kotlin-android")
        }

        @Suppress("UnstableApiUsage")
        android {
            namespace = Metadata.namespace("app")
            compileSdk = Versions.${naming.default}.SDK_COMPILE

            defaultConfig {
                applicationId = Metadata.GROUP
                minSdk = Versions.${naming.default}.SDK_MIN
                targetSdk = Versions.${naming.default}.SDK_TARGET
                versionCode = Versions.${naming.default}.CODE
                versionName = Versions.${naming.default}.NAME
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildTypes {
                getByName(Variants.RELEASE) {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            compileOptions {
                sourceCompatibility = Versions.java
                targetCompatibility = Versions.java
            }

            kotlinOptions {
                jvmTarget = Versions.java.toString()
            }
        }
    """
}
