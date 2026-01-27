package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Chest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.Chest"])
@PlatformSide(Platform.BUKKIT)
object FnChest {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chest::class.java)
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
