package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Hopper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Hopper"])
@PlatformSide(Platform.BUKKIT)
object FnHopper {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hopper::class.java)
                .function("isEnabled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isEnabled) }
                .function("setEnabled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEnabled(it.getBool(0))) }
        }
    }
}
