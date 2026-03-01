package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.World
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.World\$Spigot"])
@PlatformSide(Platform.BUKKIT)
object FnWorldSpigot {

    val TYPE = Type.fromClass(World.Spigot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.World.Spigot::class.java)
                // static
        }
    }
}
