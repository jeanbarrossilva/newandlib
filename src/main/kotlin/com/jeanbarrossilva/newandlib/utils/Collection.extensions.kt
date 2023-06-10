package com.jeanbarrossilva.newandlib.utils

import com.jeanbarrossilva.newandlib.tool.extensions.plus
import java.nio.file.Path

/** Sums the [Path]s present in this [Collection], forming a single one. **/
internal fun Collection<Path>.sum(): Path {
    var path = Path.of("")
    forEach { path += it }
    return path
}
