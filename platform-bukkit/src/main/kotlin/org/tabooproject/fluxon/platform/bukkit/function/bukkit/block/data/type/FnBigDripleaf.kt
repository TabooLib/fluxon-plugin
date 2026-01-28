package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BigDripleaf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.BigDripleaf"])
@PlatformSide(Platform.BUKKIT)
object FnBigDripleaf {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BigDripleaf::class.java)
                .function("tilt", returnsObject().noParams()) { it.target?.tilt }
                .function("setTilt", returnsObject().params(Type.OBJECT)) { it.target?.setTilt(it.getRef(0) as BigDripleaf.Tilt) }
        }
    }
}
