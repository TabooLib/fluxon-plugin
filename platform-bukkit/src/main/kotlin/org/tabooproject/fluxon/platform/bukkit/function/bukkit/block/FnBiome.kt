package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Biome
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Biome"])
@PlatformSide(Platform.BUKKIT)
object FnBiome {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Biome::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
