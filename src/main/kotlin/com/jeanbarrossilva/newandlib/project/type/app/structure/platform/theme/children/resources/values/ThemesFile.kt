package com.jeanbarrossilva.newandlib.project.type.app.structure.platform.theme.children.resources.values

import com.jeanbarrossilva.newandlib.project.info.Naming
import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class ThemesFile(override val parentPath: Path, naming: Naming) : TextFile() {
    override val name = "themes.xml"
    override val text = """
        <resources xmlns:tools="http://schemas.android.com/tools">
        <bool name="is_system_in_light_theme">true</bool>
        <color name="normal_control_color">@android:color/black</color>
        <style name="Theme.${naming.default}" parent="Theme.Material3.DayNight.NoActionBar">
            <item name="android:navigationBarColor">@android:color/transparent</item>
            <item name="android:statusBarColor">@android:color/transparent</item>
            <item
                name="android:windowLightNavigationBar"
                tools:targetApi="27">
                @bool/is_system_in_light_theme
            </item>
            <item name="android:windowLightStatusBar">@bool/is_system_in_light_theme</item>
            <item name="colorControlNormal">@color/normal_control_color</item>
        </style>
    </resources>
    """
}
