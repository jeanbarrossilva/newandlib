package com.jeanbarrossilva.newandlib.project.type.app.structure.app

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class OnBottomAreaAvailabilityChangeListenerImplementationFile(
    override val parentPath: Path,
    naming: Naming,
    `package`: Package
) : TextFile() {
    private val listenerName = naming.default + "OnBottomAreaAvailabilityChangeListener"

    override val name = "$listenerName.kt"
    override val text = """
        package ${`package`.name}.app

        import androidx.compose.runtime.getValue
        import androidx.compose.runtime.mutableStateOf
        import androidx.compose.runtime.setValue
        import ${`package`.name}.platform.theme.reactivity.OnBottomAreaAvailabilityChangeListener
        
        internal class $listenerName :
            OnBottomAreaAvailabilityChangeListener {
            var isAvailable by mutableStateOf(false)
        
            override fun onBottomAreaAvailabilityChange(isAvailable: Boolean) {
                this.isAvailable = isAvailable
            }
        }
    """
}
