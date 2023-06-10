package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.main.reactivity

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class OnBottomAreaAvailabilityChangeListenerFile(override val parentPath: Path, project: Project) :
    TextFile() {
    override val name = "OnBottomAreaAvailabilityChangeListener.kt"
    override val text = """
        package ${project.`package`.name}.platform.theme.reactivity

        /**
         * Listens to changes on the availability of the utmost bottom portion of the displayed content.
         **/
        interface OnBottomAreaAvailabilityChangeListener {
            /**
             * Callback run whenever the availability of the bottom area is changed.
             *
             * @param isAvailable Whether the bottom area is currently available.
             **/
            fun onBottomAreaAvailabilityChange(isAvailable: Boolean)

            companion object {
                /** No-op [OnBottomAreaAvailabilityChangeListener]. **/
                val empty = object : OnBottomAreaAvailabilityChangeListener {
                    override fun onBottomAreaAvailabilityChange(isAvailable: Boolean) {
                    }
                }
            }
        }
    """
}
