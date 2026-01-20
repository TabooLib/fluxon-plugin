package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Conduit
import org.bukkit.entity.LivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnConduit {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Conduit::class.java)
                .function("isActive", 0) { it.target?.isActive }
                .function("isHunting", 0) { it.target?.isHunting }
                .function("frameBlocks", 0) { it.target?.frameBlocks }
                .function("frameBlockCount", 0) { it.target?.frameBlockCount }
                .function("range", 0) { it.target?.range }
                .function("setTarget", 1) { it.target?.setTarget(it.getArgument(0) as LivingEntity) }
                .function("target", 0) { it.target?.target }
                .function("hasTarget", 0) { it.target?.hasTarget() }
                .function("huntingArea", 0) { it.target?.huntingArea }
        }
    }
}
