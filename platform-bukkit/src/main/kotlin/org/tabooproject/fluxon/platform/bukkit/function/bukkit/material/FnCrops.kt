package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.CropState
import org.bukkit.material.Crops
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.Crops"])
@PlatformSide(Platform.BUKKIT)
object FnCrops {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crops::class.java)
                .function("state", 0) { it.target?.state }
                .function("setState", 1) { it.target?.setState(it.getArgument(0) as CropState) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
