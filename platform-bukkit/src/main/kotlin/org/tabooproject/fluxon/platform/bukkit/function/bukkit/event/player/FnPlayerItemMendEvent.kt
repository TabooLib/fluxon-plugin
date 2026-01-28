package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerItemMendEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.player.PlayerItemMendEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerItemMendEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerItemMendEvent::class.java)
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("slot", returnsObject().noParams()) { it.setReturnRef(it.target?.slot) }
                .function("experienceOrb", returnsObject().noParams()) { it.setReturnRef(it.target?.experienceOrb) }
                .function("repairAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.repairAmount) }
                .function("setRepairAmount", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRepairAmount(it.getInt(0).toInt())) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerItemMendEvent.getHandlerList()) }
        }
    }
}
