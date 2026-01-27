package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.FlowerPot
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.FlowerPot"])
@PlatformSide(Platform.BUKKIT)
object FnFlowerPot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FlowerPot::class.java)
                .function("contents", 0) { it.target?.contents }
                .function("setContents", 1) { it.target?.setContents(it.getArgument(0) as MaterialData) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
