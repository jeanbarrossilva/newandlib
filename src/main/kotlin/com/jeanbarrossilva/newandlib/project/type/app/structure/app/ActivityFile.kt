package com.jeanbarrossilva.newandlib.project.type.app.structure.app

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.project.info.Package
import com.jeanbarrossilva.newandlib.project.type.app.entrypoint
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class ActivityFile(override val parentPath: Path, naming: Naming, `package`: Package) : TextFile() {
    private val activityName = naming.default + "Activity"

    override val name = "$activityName.kt"
    override val text = """
        package ${`package`.name}.app

        import android.os.Bundle
        import androidx.activity.compose.setContent
        import androidx.appcompat.app.AppCompatActivity
        import androidx.core.view.WindowCompat

        internal class $activityName : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                WindowCompat.setDecorFitsSystemWindows(window, false)
                setContent { ${naming.entrypoint}() }
            }
        }
    """
}
