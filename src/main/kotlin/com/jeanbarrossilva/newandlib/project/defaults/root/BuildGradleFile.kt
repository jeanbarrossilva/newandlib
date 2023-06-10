package com.jeanbarrossilva.newandlib.project.defaults.root

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class BuildGradleFile(override val parentPath: Path) : TextFile() {
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
