package com.jeanbarrossilva.newandlib.tool.file.writer

fun at(origin: String, writing: FileWriter.() -> Unit) {
    FileWriter(origin).apply(writing)
}
