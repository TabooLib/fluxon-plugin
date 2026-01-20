package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.types

import org.bukkit.block.BlockFace
import org.bukkit.material.types.MushroomBlockTexture
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMushroomBlockTexture {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MushroomBlockTexture::class.java)
                .function("data", 0) { it.target?.data }
                .function("capFace", 0) { it.target?.capFace }
                // static
                .function("byData", 1) { MushroomBlockTexture.getByData(it.getNumber(0).toByte()) }
                // static
                .function("capByFace", 1) { MushroomBlockTexture.getCapByFace(it.getArgument(0) as BlockFace) }
        }
    }
}
