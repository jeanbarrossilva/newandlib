package com.jeanbarrossilva.newandlib.generator

import com.jeanbarrossilva.newandlib.Generator
import com.jeanbarrossilva.newandlib.Prompts
import com.jeanbarrossilva.newandlib.prompter.Prompter
import com.jeanbarrossilva.newandlib.prompter.hyphenatedProjectName
import com.jeanbarrossilva.newandlib.prompter.lowerCamelCasedProjectName
import java.nio.file.Paths
import kotlin.io.path.createDirectories

internal class LibraryGenerator(override val prompter: Prompter) : Generator() {
    override fun onGenerate() {
        generateLibraryFiles()
    }

    private fun generateLibraryFiles() {
        val moduleName = prompter.hyphenatedProjectName
        val `package` = prompter[Prompts.GROUP_ID]!!.replace('/', '.')
        Paths.get("$moduleName/src/main/java/$`package`").createDirectories()
        generateManifestAt("$moduleName/src/main")
        fileWriter.writeTo("$moduleName/.gitignore", "/build")
        fileWriter.writeTo("$moduleName/build.gradle.kts", """
            plugins {
                id("com.android.library")
                id("kotlin-android")
                `maven-publish`
            }

            publishing {
                repositories {
                    ${prompter.lowerCamelCasedProjectName}()
                }

                publications {
                    register<MavenPublication>(Variants.RELEASE) {
                        groupId = Metadata.GROUP
                        artifactId = Metadata.ARTIFACT
                        version = Versions.${prompter[Prompts.PROJECT_NAME]}.NAME

                        afterEvaluate {
                            from(components[Variants.RELEASE])
                        }
                    }
                }
            }

            @Suppress("UnstableApiUsage")
            android {
                namespace = Metadata.NAMESPACE
                compileSdk = Versions.${prompter[Prompts.PROJECT_NAME]}.SDK_COMPILE

                defaultConfig {
                    minSdk = Versions.${prompter[Prompts.PROJECT_NAME]}.SDK_MIN
            
                    @Suppress("DEPRECATION")
                    targetSdk = Versions.${prompter[Prompts.PROJECT_NAME]}.SDK_TARGET
            
                    testInstrumentationRunner = Libraries.TEST_RUNNER
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
        """)
    }
}
