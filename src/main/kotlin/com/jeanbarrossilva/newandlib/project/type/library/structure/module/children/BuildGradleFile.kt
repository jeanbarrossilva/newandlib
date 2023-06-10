package com.jeanbarrossilva.newandlib.project.type.library.structure.module.children

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class BuildGradleFile(override val parentPath: Path, naming: Naming) : TextFile() {
    override val name = "build.gradle.kts"
    override val text = """
        plugins {
            id("com.android.library")
            id("kotlin-android")
            `maven-publish`
        }

        publishing {
            repositories {
                ${naming.lowerCamelCased}()
            }

            publications {
                register<MavenPublication>(Variants.RELEASE) {
                    groupId = Metadata.GROUP
                    artifactId = Metadata.ARTIFACT
                    version = Versions.${naming.default}.NAME

                    afterEvaluate {
                        from(components[Variants.RELEASE])
                    }
                }
            }
        }

        @Suppress("UnstableApiUsage")
        android {
            namespace = Metadata.NAMESPACE
            compileSdk = Versions.${naming.default}.SDK_COMPILE

            defaultConfig {
                minSdk = Versions.${naming.default}.SDK_MIN
        
                @Suppress("DEPRECATION")
                targetSdk = Versions.${naming.default}.SDK_TARGET
        
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            publishing {
                singleVariant(Variants.RELEASE) {
                    withSourcesJar()
                    withJavadocJar()
                }
            }

            buildTypes {
                getByName(Variants.RELEASE) {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            buildFeatures {
                viewBinding = true
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
