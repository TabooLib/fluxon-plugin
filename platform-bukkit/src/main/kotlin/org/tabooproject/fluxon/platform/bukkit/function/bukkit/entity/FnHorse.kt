package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Horse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Horse"])
@PlatformSide(Platform.BUKKIT)
object FnHorse {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Horse::class.java)
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as Horse.Color) }
                .function("style", 0) { it.target?.style }
                .function("setStyle", 1) { it.target?.setStyle(it.getArgument(0) as Horse.Style) }
                .function("isCarryingChest", 0) { it.target?.isCarryingChest }
                .function("setCarryingChest", 1) { it.target?.setCarryingChest(it.getBoolean(0)) }
                .function("inventory", 0) { it.target?.inventory }
        }
    }
}
