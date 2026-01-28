package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Crafter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Crafter"])
@PlatformSide(Platform.BUKKIT)
object FnCrafter {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crafter::class.java)
                .function("isCrafting", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCrafting) }
                .function("setCrafting", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCrafting(it.getBool(0))) }
                .function("isTriggered", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isTriggered) }
                .function("setTriggered", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTriggered(it.getBool(0))) }
                .function("orientation", returnsObject().noParams()) { it.setReturnRef(it.target?.orientation) }
                .function("setOrientation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setOrientation(it.getRef(0) as Crafter.Orientation)) }
        }
    }
}
