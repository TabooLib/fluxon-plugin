package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.packs.ResourcePack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnResourcePack {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ResourcePack::class.java)
                .function("id", 0) { it.target?.id }
                .function("url", 0) { it.target?.url }
                .function("hash", 0) { it.target?.hash }
                .function("prompt", 0) { it.target?.prompt }
                .function("isRequired", 0) { it.target?.isRequired }
        }
    }
}
