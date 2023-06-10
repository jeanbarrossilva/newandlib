package com.jeanbarrossilva.newandlib.tool.file.writer

import java.nio.file.Paths
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.createDirectory
import kotlin.io.path.deleteRecursively
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class FileWriterTests {
    private val fileName = "file-writer-tests.txt"
    private val fileParentPath = "outputs"
    private val filePath = "$fileParentPath/$fileName"
    private val writer = FileWriter(fileParentPath)

    private val file
        get() = Paths.get(filePath).toFile()

    @BeforeTest
    fun setUp() {
        Paths.get(fileParentPath).createDirectory()
    }

    @OptIn(ExperimentalPathApi::class)
    @AfterTest
    fun tearDown() {
        Paths.get(fileParentPath).deleteRecursively()
    }

    @Test
    fun `GIVEN a content WHEN writing it to a file THEN it is written`() {
        writer.writeTo(fileName, "Hello, world!")
        assertEquals("Hello, world!\n", file.reader().readText())
    }

    @Test
    fun `GIVEN some code WHEN writing it to a file THEN it is line-broken and indented correctly`() {
        writer.writeTo(fileName, """
            fun main() {
                println("Hello!")
            }
        """)
        assertEquals("fun main() {\n    println(\"Hello!\")\n}\n", file.reader().readText())
    }
}
