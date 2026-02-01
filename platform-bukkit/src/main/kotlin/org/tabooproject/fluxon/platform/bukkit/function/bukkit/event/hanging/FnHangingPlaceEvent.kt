package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingPlaceEvent
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

@Requires(classes = ["org.bukkit.event.hanging.HangingPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHangingPlaceEvent {

    val TYPE = Type.fromClass(HangingPlaceEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingPlaceEvent::class.java)
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
                .function("blockFace", returnsObject().noParams()) { it.setReturnRef(it.target?.blockFace) }
                .function("hand", returnsObject().noParams()) { it.setReturnRef(it.target?.hand) }
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(HangingPlaceEvent.getHandlerList()) }
        }
    }
}
