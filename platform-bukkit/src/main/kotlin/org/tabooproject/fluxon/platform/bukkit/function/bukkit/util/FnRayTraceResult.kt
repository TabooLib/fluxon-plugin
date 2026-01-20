package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.RayTraceResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRayTraceResult {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RayTraceResult::class.java)
                .function("hitPosition", 0) { it.target?.hitPosition }
                .function("hitBlock", 0) { it.target?.hitBlock }
                .function("hitBlockFace", 0) { it.target?.hitBlockFace }
                .function("hitEntity", 0) { it.target?.hitEntity }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
