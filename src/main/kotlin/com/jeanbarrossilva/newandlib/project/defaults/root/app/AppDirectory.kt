package com.jeanbarrossilva.newandlib.project.defaults.root.app

import com.jeanbarrossilva.newandlib.project.defaults.root.app.children.AndroidManifestFile
import com.jeanbarrossilva.newandlib.project.defaults.root.app.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.mainSource
import java.nio.file.Path

internal class AppDirectory(root: Path) : Directory() {
    override val path = root + at("app")
    override val children = listOf(AndroidManifestFile(path.mainSource), GitIgnoreFile(path))
}
