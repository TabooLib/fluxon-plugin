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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.BiomeSearchResult"])
@PlatformSide(Platform.BUKKIT)
object FnBiomeSearchResult {

    val TYPE = Type.fromClass(BiomeSearchResult::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BiomeSearchResult::class.java)
                .function("biome",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBiome.TYPE).noParams()) { it.setReturnRef(it.target?.biome) }
                .function("location",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
