package com.jeanbarrossilva.newandlib.project.root.app

import com.jeanbarrossilva.newandlib.project.Naming
import com.jeanbarrossilva.newandlib.project.root.app.children.AndroidManifestFile
import com.jeanbarrossilva.newandlib.project.root.app.children.BuildGradleFile
import com.jeanbarrossilva.newandlib.project.root.app.children.GitIgnoreFile
import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.utils.mainSource
import java.nio.file.Path

internal class AppDirectory(root: Path, naming: Naming) : Directory {
    override val path = root + at("app")
    override val children =
        listOf(AndroidManifestFile(this + path.mainSource), BuildGradleFile(this, naming), GitIgnoreFile(this))
}
