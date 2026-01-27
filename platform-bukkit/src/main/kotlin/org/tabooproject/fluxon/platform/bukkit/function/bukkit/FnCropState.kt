package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.CropState
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.CropState"])
@PlatformSide(Platform.BUKKIT)
object FnCropState {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CropState::class.java)
                .function("data", 0) { it.target?.data }
                // static
                .function("getByData", 1) { CropState.getByData(it.getNumber(0).toByte()) }
        }
    }
}
