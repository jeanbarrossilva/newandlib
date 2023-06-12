package com.jeanbarrossilva.newandlib.project.type.app.structure.app

import com.jeanbarrossilva.newandlib.project.Project
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class ApplicationFile(override val parentPath: Path, project: Project) : TextFile() {
    private val applicationName = project.naming.default + "Application"
    override val name = "$applicationName.kt"

    @Suppress("SpellCheckingInspection")
    override val text = """
        package ${project.`package`.name}.app

        import android.app.Application
        import android.content.Context
        import androidx.annotation.Discouraged
        import androidx.core.content.edit
        import ${project.`package`.name}.platform.launchable.Launchable
        import org.koin.android.ext.koin.androidContext
        import org.koin.core.context.startKoin

        internal open class $applicationName : Application(), Launchable {
            private val preferences
                get() = getSharedPreferences("${project.naming.hyphenated}", Context.MODE_PRIVATE)

            override fun onCreate() {
                super.onCreate()

                @Suppress("DiscouragedApi")
                markAsLaunched()

                inject()
            }

            override fun count(): Int {
                return preferences.getInt(LAUNCH_COUNT_PREFERENCE_KEY, 0)
            }

            @Discouraged("Should only be called by $applicationName internally.")
            override fun markAsLaunched() {
                preferences.edit {
                    putInt(LAUNCH_COUNT_PREFERENCE_KEY, count() + 1)
                }
            }

            private fun inject() {
                startKoin {
                    androidContext(this@$applicationName)
                }
            }

            companion object {
                private const val LAUNCH_COUNT_PREFERENCE_KEY = "launch_count"
            }
        }
    """
}
