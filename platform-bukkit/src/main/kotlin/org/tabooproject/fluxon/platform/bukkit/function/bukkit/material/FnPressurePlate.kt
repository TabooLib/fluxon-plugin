package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.PressurePlate
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.PressurePlate"])
@PlatformSide(Platform.BUKKIT)
object FnPressurePlate {

    val TYPE = Type.fromClass(PressurePlate::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PressurePlate::class.java)
                .function("isPressed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPressed ?: false) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
