package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Tripwire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.material.Tripwire"])
@PlatformSide(Platform.BUKKIT)
object FnTripwire {

    val TYPE = Type.fromClass(Tripwire::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tripwire::class.java)
                .function("isActivated", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isActivated ?: false) }
                .function("setActivated", returnsVoid().params(Type.Z)) { it.target?.setActivated(it.getBool(0)) }
                .function("isObjectTriggering", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isObjectTriggering ?: false) }
                .function("setObjectTriggering", returnsVoid().params(Type.Z)) { it.target?.setObjectTriggering(it.getBool(0)) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
