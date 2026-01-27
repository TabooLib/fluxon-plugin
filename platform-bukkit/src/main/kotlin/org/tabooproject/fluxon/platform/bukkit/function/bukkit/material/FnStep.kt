package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Step
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.Step"])
@PlatformSide(Platform.BUKKIT)
object FnStep {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Step::class.java)
                .function("textures", 0) { it.target?.textures }
                .function("isInverted", 0) { it.target?.isInverted }
                .function("setInverted", 1) { it.target?.setInverted(it.getBoolean(0)) }
                .function("clone", 0) { it.target?.clone() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
