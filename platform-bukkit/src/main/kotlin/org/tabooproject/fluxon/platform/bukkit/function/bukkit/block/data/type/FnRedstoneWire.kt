package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.RedstoneWire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRedstoneWire {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RedstoneWire::class.java)
                .function("face", 1) { it.target?.getFace(it.getArgument(0) as BlockFace) }
                .function("setFace", 2) {
                    it.target?.setFace(
                        it.getArgument(0) as BlockFace,
                        it.getArgument(1) as RedstoneWire.Connection
                    )
                }
                .function("allowedFaces", 0) { it.target?.allowedFaces }
        }
    }
}
