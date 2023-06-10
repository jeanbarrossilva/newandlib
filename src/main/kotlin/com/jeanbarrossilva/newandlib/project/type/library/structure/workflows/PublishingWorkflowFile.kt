package com.jeanbarrossilva.newandlib.project.type.library.structure.workflows

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class PublishingWorkflowFile(override val directory: Directory) : TextFile() {
    override val name = "publishing.yml"

    @Suppress("SpellCheckingInspection")
    override val text = """
        name: Publishing
        on:
          release:
            types: [created]
        jobs:
          build:
            runs-on: ubuntu-latest
            permissions:
              contents: read
              packages: write
            steps:
              - uses: actions/checkout@v3

              - name: Set up Java 11
                uses: actions/setup-java@v3
                with:
                  java-version: '11'
                  distribution: 'temurin'
                  server-id: github
                  settings-path: ${'$'}{{ github.workspace }}

              - name: Build
                uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
                with:
                  arguments: build

              - name: Publish
                env:
                  GITHUB_USERNAME: ${'$'}{{ github.actor }}
                  GITHUB_TOKEN: ${'$'}{{ secrets.GITHUB_TOKEN }}
                uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
                with:
                  arguments: publish
    """
}
