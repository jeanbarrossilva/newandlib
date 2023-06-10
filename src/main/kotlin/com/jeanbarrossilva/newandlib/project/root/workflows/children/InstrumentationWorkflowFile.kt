package com.jeanbarrossilva.newandlib.project.root.workflows.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class InstrumentationWorkflowFile(override val parentPath: Path) : TextFile() {
    override val name = "instrumentation.yml"

    @Suppress("SpellCheckingInspection")
    override val text = """
        name: Instrumented tests
        on:
          push:
            branches: [ "main" ]
          pull_request:
            branches: [ "main" ]
        permissions:
          contents: read
        jobs:
          test:
            runs-on: macos-latest
            steps:
              - name: Check out
                uses: actions/checkout@v3

              - name: Set up Java 11
                uses: actions/setup-java@v1
                with:
                  java-version: 11

              - name: Run instrumented tests
                uses: reactivecircus/android-emulator-runner@v2.27.0
                with:
                  api-level: 31
                  arch: x86_64
                  disable-animations: true
                  disk-size: 2000M
                  heap-size: 600M
                  script: ./gradlew connectedCheck
    """
}
