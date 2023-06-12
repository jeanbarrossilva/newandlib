package com.jeanbarrossilva.newandlib.project.defaults.root.workflows.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class FormattingWorkflowFile(override val parentPath: Path) : TextFile() {
    override val name = "formatting.yml"

    @Suppress("SpellCheckingInspection")
    override val text = """
        name: Lint
        on:
          pull_request:
            branches: [ "main" ]
          push:
            branches: [ "main" ]
        jobs:
          ktlint:
            permissions:
              contents: read
            runs-on: ubuntu-latest
            steps:
              - uses: actions/checkout@master
        
              - name: ktlint
                uses: ScaCap/action-ktlint@master
                with:
                  android: true
                  github_token: ${'$'}{{ secrets.github_token }}
                  reporter: github-check
    """
}
