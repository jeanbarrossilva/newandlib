package com.jeanbarrossilva.newandlib.project.root.app.children

import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class AndroidManifestFile(override val directory: Directory) : TextFile() {
    override val name = "AndroidManifest.xml"
    override val text = """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest />
    """
}
