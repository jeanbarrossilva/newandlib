package com.jeanbarrossilva.newandlib.tool.writer

fun at(origin: String, writing: FileWriter.() -> Unit) {
    FileWriter(origin).apply(writing)
}
