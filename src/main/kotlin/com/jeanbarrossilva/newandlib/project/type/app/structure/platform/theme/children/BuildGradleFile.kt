package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class BuildGradleFile(override val parentPath: Path, naming: Naming) : TextFile() {
    override val name = "build.gradle.kts"
    override val text = """
        plugins {
            id("com.android.library")
            id("org.jetbrains.kotlin.android")
        }
        
        android {
            namespace = Metadata.namespace("platform.theme")
            compileSdk = Versions.${naming.default}.SDK_TARGET
        
            defaultConfig {
                minSdk = Versions.${naming.default}.SDK_MIN
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }
        
            buildTypes {
                release {
                    isMinifyEnabled = true
        
                    @Suppress("UnstableApiUsage")
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        
            @Suppress("UnstableApiUsage")
            buildFeatures {
                compose = true
            }
        
            compileOptions {
                sourceCompatibility = Versions.java
                targetCompatibility = Versions.java
            }
        
            kotlinOptions {
                jvmTarget = Versions.java.toString()
            }
        
            composeOptions {
                kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
            }
        }
        
        dependencies {
            api(Dependencies.COMPOSE_MATERIAL_3)
            api(Dependencies.COMPOSE_UI_TOOLING)
        
            implementation(Dependencies.MATERIAL)
        }
    """
}
