package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.DaylightDetector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.DaylightDetector"])
@PlatformSide(Platform.BUKKIT)
object FnDaylightDetector {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DaylightDetector::class.java)
                .function("isInverted", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isInverted) }
                .function("setInverted", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setInverted(it.getBool(0))) }
        }
    }
}
