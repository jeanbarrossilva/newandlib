package com.jeanbarrossilva.newandlib.project

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.utils.sum
import java.nio.file.Path

internal class Package private constructor(val name: String, val path: Path) {
    companion object {
        infix fun named(name: String): Package {
            val path = name.split('.').map(::at).sum()
            return Package(name, path)
        }
    }
}
