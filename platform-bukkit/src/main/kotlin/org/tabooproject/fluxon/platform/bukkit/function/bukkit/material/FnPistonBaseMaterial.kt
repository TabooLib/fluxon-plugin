package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.PistonBaseMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.PistonBaseMaterial"])
@PlatformSide(Platform.BUKKIT)
object FnPistonBaseMaterial {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonBaseMaterial::class.java)
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("facing", 0) { it.target?.facing }
                .function("isPowered", 0) { it.target?.isPowered }
                .function("setPowered", 1) { it.target?.setPowered(it.getBoolean(0)) }
                .function("isSticky", 0) { it.target?.isSticky }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
