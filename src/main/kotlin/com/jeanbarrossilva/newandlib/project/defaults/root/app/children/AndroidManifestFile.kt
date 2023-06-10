package com.jeanbarrossilva.newandlib.project.defaults.root.app.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class AndroidManifestFile(override val parentPath: Path) : TextFile() {
    override val name = "AndroidManifest.xml"
    override val text = """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest />
    """
}
