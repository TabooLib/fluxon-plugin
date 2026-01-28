package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Rotation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Rotation"])
@PlatformSide(Platform.BUKKIT)
object FnRotation {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rotation::class.java)
                .function("rotateClockwise", returnsObject().noParams()) { it.target?.rotateClockwise() }
                .function("rotateCounterClockwise", returnsObject().noParams()) { it.target?.rotateCounterClockwise() }
        }
    }
}
