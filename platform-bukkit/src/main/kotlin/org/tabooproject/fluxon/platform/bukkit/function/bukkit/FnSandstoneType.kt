package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.SandstoneType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.SandstoneType"])
@PlatformSide(Platform.BUKKIT)
object FnSandstoneType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SandstoneType::class.java)
                .function("data", 0) { it.target?.data }
                // static
                .function("getByData", 1) { SandstoneType.getByData(it.getNumber(0).toByte()) }
        }
    }
}
