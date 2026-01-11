package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Mushroom
import org.bukkit.material.types.MushroomBlockTexture
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMushroom {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mushroom::class.java)
                .function("isStem", 0) { it.target?.isStem }
                .function("setStem", 0) { it.target?.setStem() }
                .function("blockTexture", 0) { it.target?.blockTexture }
                .function(
                    "setBlockTexture",
                    1
                ) { it.target?.setBlockTexture(it.getArgument(0) as MushroomBlockTexture) }
                .function("isFacePainted", 1) { it.target?.isFacePainted(it.getArgument(0) as BlockFace) }
                .function("setFacePainted", 2) {
                    it.target?.setFacePainted(
                        it.getArgument(0) as BlockFace,
                        it.getBoolean(1)
                    )
                }
                .function("paintedFaces", 0) { it.target?.paintedFaces }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
