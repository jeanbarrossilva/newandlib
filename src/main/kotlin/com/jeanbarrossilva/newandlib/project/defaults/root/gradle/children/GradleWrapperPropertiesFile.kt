package com.jeanbarrossilva.newandlib.project.defaults.root.gradle.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import com.jeanbarrossilva.newandlib.utils.GradleWrapperPropertiesHeaderDateTimeFormatter
import java.nio.file.Path
import java.time.ZonedDateTime

internal class GradleWrapperPropertiesFile(override val parentPath: Path) : TextFile() {
    override val name = "gradle-wrapper.properties"

    @Suppress("SpellCheckingInspection")
    override val text = """
        #${ZonedDateTime.now().format(GradleWrapperPropertiesHeaderDateTimeFormatter())}
        distributionBase=GRADLE_USER_HOME
        distributionUrl=https\://services.gradle.org/distributions/gradle-8.1-all.zip
        distributionPath=wrapper/dists
        zipStorePath=wrapper/dists
        zipStoreBase=GRADLE_USER_HOME
    """
}
