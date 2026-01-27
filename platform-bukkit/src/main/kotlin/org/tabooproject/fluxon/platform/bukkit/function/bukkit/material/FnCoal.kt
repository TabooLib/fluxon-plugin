package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.CoalType
import org.bukkit.material.Coal
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.Coal"])
@PlatformSide(Platform.BUKKIT)
object FnCoal {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Coal::class.java)
                .function("type", 0) { it.target?.type }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as CoalType) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
