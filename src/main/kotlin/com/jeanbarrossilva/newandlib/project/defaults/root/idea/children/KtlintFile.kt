package com.jeanbarrossilva.newandlib.project.defaults.root.idea.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

@Suppress("SpellCheckingInspection")
internal class KtlintFile(override val parentPath: Path) : TextFile() {
    override val name = "ktlint.xml"
    override val text = """
        <?xml version="1.0" encoding="UTF-8"?>
        <project version="4">
          <component name="KtlintProjectConfiguration">
            <androidMode>true</androidMode>
            <formatOnSave>true</formatOnSave>
          </component>
        </project>
    """
}
