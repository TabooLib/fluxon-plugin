package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.packs.DataPack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDataPack {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DataPack::class.java)
                .function("title", 0) { it.target?.title }
                .function("description", 0) { it.target?.description }
                .function("packFormat", 0) { it.target?.packFormat }
                .function("minSupportedPackFormat", 0) { it.target?.minSupportedPackFormat }
                .function("maxSupportedPackFormat", 0) { it.target?.maxSupportedPackFormat }
                .function("isEnabled", 0) { it.target?.isEnabled }
                .function("isRequired", 0) { it.target?.isRequired }
                .function("compatibility", 0) { it.target?.compatibility }
                .function("requestedFeatures", 0) { it.target?.requestedFeatures }
                .function("source", 0) { it.target?.source }
        }
    }
}
