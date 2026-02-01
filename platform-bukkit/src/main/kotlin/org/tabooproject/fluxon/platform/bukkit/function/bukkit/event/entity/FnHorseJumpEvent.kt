package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.HorseJumpEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.HorseJumpEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHorseJumpEvent {

    val TYPE = Type.fromClass(HorseJumpEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HorseJumpEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("power", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.power ?: 0f) }
                .function("setPower", returnsVoid().params(Type.F)) { it.target?.setPower(it.getFloat(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(HorseJumpEvent.getHandlerList()) }
        }
    }
}
