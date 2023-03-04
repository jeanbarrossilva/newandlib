package com.jeanbarrossilva.newandlib.utils

import java.nio.file.Paths

/** Relative path of where the program is being currently executed. **/
internal val currentPath
    get() = Paths.get("").toAbsolutePath().toString()
