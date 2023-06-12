package com.jeanbarrossilva.newandlib.project.type.app.structure.buildsrc.children

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class DependenciesFile(override val parentPath: Path) : TextFile() {
    override val name = "Dependencies.kt"

    @Suppress("SpellCheckingInspection")
    override val text = """
        object Dependencies {
            @Suppress("SpellCheckingInspection")
            const val COMPOSE_DESTINATION_ANIMATIONS =
                "io.github.raamcosta.compose-destinations:animations-core:${'$'}{Versions.COMPOSE_DESTINATIONS}"

            @Suppress("SpellCheckingInspection")
            const val COMPOSE_DESTINATIONS_CORE =
                "io.github.raamcosta.compose-destinations:core${'$'}{Versions.COMPOSE_DESTINATIONS}"

            const val COMPOSE_MATERIAL_3 =
                "androidx.compose.material3:material3-android:${'$'}{Versions.COMPOSE_MATERIAL_3}"
            const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${'$'}{Versions.COMPOSE_UI_TOOLING}"
            const val COROUTINES_CORE =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${'$'}{Versions.COROUTINES}"

            const val KOIN = "io.insert-koin:koin-androidx-compose:${'$'}{Versions.KOIN}"
            const val LOADABLE = "com.jeanbarrossilva.loadable:loadable:${'$'}{Versions.LOADABLE}"
            const val LOADABLE_LIST = "com.jeanbarrossilva.loadable:loadable-list:${'$'}{Versions.LOADABLE}"
            const val MATERIAL = "com.google.android.material:material:${'$'}{Versions.MATERIAL}"
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${'$'}{Versions.VIEWMODEL}"
        }
    """
}
