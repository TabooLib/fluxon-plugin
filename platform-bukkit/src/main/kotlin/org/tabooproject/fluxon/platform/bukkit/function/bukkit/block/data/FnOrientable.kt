package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.Axis
import org.bukkit.block.data.Orientable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Orientable"])
@PlatformSide(Platform.BUKKIT)
object FnOrientable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Orientable::class.java)
                .function("axis", returnsObject().noParams()) { it.setReturnRef(it.target?.axis) }
                .function("setAxis", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAxis(it.getRef(0) as Axis)) }
                .function("axes", returnsObject().noParams()) { it.setReturnRef(it.target?.axes) }
        }
    }
}
