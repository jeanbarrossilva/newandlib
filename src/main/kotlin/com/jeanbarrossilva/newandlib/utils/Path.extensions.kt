package com.jeanbarrossilva.newandlib.utils

import com.jeanbarrossilva.newandlib.tool.extensions.at
import com.jeanbarrossilva.newandlib.tool.extensions.plus
import java.nio.file.Path

/** [Path] originating from this one in which the Java source of a Java project is located. **/
internal val Path.javaMainSource
    get() = mainSource + at("java")

/** [Path] originating from this one in which the source of a Java project is located. **/
internal val Path.mainSource
    get() = this + at("src") + at("main")
