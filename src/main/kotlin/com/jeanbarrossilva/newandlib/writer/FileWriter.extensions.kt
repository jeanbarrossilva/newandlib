package com.jeanbarrossilva.newandlib.writer

internal fun at(origin: String, writing: FileWriter.() -> Unit) {
    FileWriter(origin).apply(writing)
}
