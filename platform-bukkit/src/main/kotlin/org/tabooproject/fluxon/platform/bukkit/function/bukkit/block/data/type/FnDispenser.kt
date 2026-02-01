package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Dispenser
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.Dispenser"])
@PlatformSide(Platform.BUKKIT)
object FnDispenser {

    val TYPE = Type.fromClass(Dispenser::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Dispenser::class.java)
                .function("isTriggered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTriggered ?: false) }
                .function("setTriggered", returnsVoid().params(Type.Z)) { it.target?.setTriggered(it.getBool(0)) }
        }
    }
}
