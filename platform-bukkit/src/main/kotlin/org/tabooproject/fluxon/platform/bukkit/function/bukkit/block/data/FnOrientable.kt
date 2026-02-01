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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Orientable"])
@PlatformSide(Platform.BUKKIT)
object FnOrientable {

    val TYPE = Type.fromClass(Orientable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Orientable::class.java)
                .function("axis", returnsObject().noParams()) { it.setReturnRef(it.target?.axis) }
                .function("setAxis", returnsVoid().params(Type.OBJECT)) { it.target?.setAxis(it.getRef(0) as Axis) }
                .function("axes", returnsObject().noParams()) { it.setReturnRef(it.target?.axes) }
        }
    }
}
