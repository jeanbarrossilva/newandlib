package com.jeanbarrossilva.newandlib.project.type.library.structure.buildsrc

import com.jeanbarrossilva.newandlib.project.Naming
import com.jeanbarrossilva.newandlib.tool.file.Directory
import com.jeanbarrossilva.newandlib.tool.file.TextFile

internal class RepositoryHandlerExtensionsFile(
    override val directory: Directory,
    naming: Naming,
    repositoryUrl: String
) : TextFile() {
    override val name = "RepositoryHandler.extensions.kt"
    override val text = """
        import java.net.URI
        import org.gradle.api.Project
        import org.gradle.api.artifacts.dsl.RepositoryHandler
        import org.gradle.api.artifacts.repositories.MavenArtifactRepository

        /** Adds the repository in which ${naming.default} is located. **/
        fun RepositoryHandler.${naming.lowerCamelCased}(): MavenArtifactRepository {
            return maven {
                url = URI.create("$repositoryUrl")

                credentials {
                    username = System.getenv("GITHUB_USERNAME")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    """
}
