package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BiomeSearchResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.BiomeSearchResult"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeSearchResult {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeSearchResult::class.java)
                .function("biome", returnsObject().noParams()) { it.setReturnRef(it.target?.biome) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
