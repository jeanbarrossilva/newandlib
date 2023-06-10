package com.jeanbarrossilva.newandlib.project.root

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class BuildGradleFile(override val directory: Directory) : TextFile() {
    override val name = "build.gradle.kts"

    @Suppress("SpellCheckingInspection")
    override val text = """
        buildscript {
            repositories {
                google()
                mavenCentral()
            }

            dependencies {
                classpath(Plugins.GRADLE)
                classpath(Plugins.KOTLIN)
            }
        }

        allprojects {
            repositories {
                google()
                mavenCentral()
            }
        }

        tasks.register<Delete>("clean") {
            delete(rootProject.buildDir)
        }
    """
}
