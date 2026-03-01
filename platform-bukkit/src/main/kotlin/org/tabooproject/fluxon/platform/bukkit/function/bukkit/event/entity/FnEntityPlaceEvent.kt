package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPlaceEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPlaceEvent {

    val TYPE = Type.fromClass(EntityPlaceEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPlaceEvent::class.java)
                .function("player",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("block",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
                .function("blockFace",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.blockFace) }
                .function("hand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.hand) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityPlaceEvent.getHandlerList()) }
        }
    }
}
