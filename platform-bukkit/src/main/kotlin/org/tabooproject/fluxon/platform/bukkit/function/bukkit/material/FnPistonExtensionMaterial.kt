package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.PistonExtensionMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPistonExtensionMaterial {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonExtensionMaterial::class.java)
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("facing", 0) { it.target?.facing }
                .function("isSticky", 0) { it.target?.isSticky }
                .function("setSticky", 1) { it.target?.setSticky(it.getBoolean(0)) }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
