package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.entity.TextDisplay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.TextDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnTextDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TextDisplay::class.java)
                .function("text", 0) { it.target?.text }
                .function("setText", 1) { it.target?.setText(it.getString(0)) }
                .function("lineWidth", 0) { it.target?.lineWidth }
                .function("setLineWidth", 1) { it.target?.setLineWidth(it.getNumber(0).toInt()) }
                .function("backgroundColor", 0) { it.target?.backgroundColor }
                .function("setBackgroundColor", 1) { it.target?.setBackgroundColor(it.getArgument(0) as Color) }
                .function("textOpacity", 0) { it.target?.textOpacity }
                .function("setTextOpacity", 1) { it.target?.setTextOpacity(it.getNumber(0).toByte()) }
                .function("isShadowed", 0) { it.target?.isShadowed }
                .function("setShadowed", 1) { it.target?.setShadowed(it.getBoolean(0)) }
                .function("isSeeThrough", 0) { it.target?.isSeeThrough }
                .function("setSeeThrough", 1) { it.target?.setSeeThrough(it.getBoolean(0)) }
                .function("isDefaultBackground", 0) { it.target?.isDefaultBackground }
                .function("setDefaultBackground", 1) { it.target?.setDefaultBackground(it.getBoolean(0)) }
                .function("alignment", 0) { it.target?.alignment }
                .function("setAlignment", 1) { it.target?.setAlignment(it.getArgument(0) as TextDisplay.TextAlignment) }
        }
    }
}
