package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Door
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDoor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Door::class.java)
                .function("hinge", 0) { it.target?.hinge }
                .function("setHinge", 1) { it.target?.setHinge(it.getArgument(0) as Door.Hinge) }
        }
    }
}
