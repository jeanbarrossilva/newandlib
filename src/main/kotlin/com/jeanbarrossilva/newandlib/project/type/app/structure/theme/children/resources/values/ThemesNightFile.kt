package com.jeanbarrossilva.newandlib.project.type.app.structure.theme.children.resources.values

import com.jeanbarrossilva.newandlib.tool.file.TextFile
import java.nio.file.Path

internal class ThemesNightFile(override val parentPath: Path) : TextFile() {
    override val name = "themes.xml"
    override val text = """
        <?xml version="1.0" encoding="utf-8"?>
        <resources>
            <bool name="is_system_in_light_theme">false</bool>
            <color name="normal_control_color">@android:color/white</color>
        </resources>
    """
}
