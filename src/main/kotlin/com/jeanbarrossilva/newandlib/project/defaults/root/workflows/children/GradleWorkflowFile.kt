package com.jeanbarrossilva.newandlib.project.defaults.root.workflows.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class GradleWorkflowFile(override val parentPath: Path) : TextFile() {
    override val name = "gradle.yml"

    @Suppress("SpellCheckingInspection")
    override val text = """
        name: Java CI with Gradle
        on:
          push:
            branches: [ "main" ]
          pull_request:
            branches: [ "main" ]
        permissions:
          contents: read
        jobs:
          build:
            runs-on: ubuntu-latest
            steps:
              - uses: actions/checkout@v3

              - name: Set up JDK 11
                uses: actions/setup-java@v3
                with:
                  java-version: '11'
                  distribution: 'temurin'

              - name: Build with Gradle
                uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
                with:
                  arguments: build
    """
}
