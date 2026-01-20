package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.data.BlockData
import org.bukkit.entity.Enderman
import org.bukkit.entity.Entity
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEnderman {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Enderman::class.java)
                .function("carriedMaterial", 0) { it.target?.carriedMaterial }
                .function("setCarriedMaterial", 1) { it.target?.setCarriedMaterial(it.getArgument(0) as MaterialData) }
                .function("carriedBlock", 0) { it.target?.carriedBlock }
                .function("setCarriedBlock", 1) { it.target?.setCarriedBlock(it.getArgument(0) as BlockData) }
                .function("teleport", 0) { it.target?.teleport() }
                .function("teleportTowards", 1) { it.target?.teleportTowards(it.getArgument(0) as Entity) }
        }
    }
}
