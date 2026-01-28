package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerArmorStandManipulateEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerArmorStandManipulateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerArmorStandManipulateEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerArmorStandManipulateEvent::class.java)
                .function("playerItem", returnsObject().noParams()) { it.target?.playerItem }
                .function("armorStandItem", returnsObject().noParams()) { it.target?.armorStandItem }
                .function("slot", returnsObject().noParams()) { it.target?.slot }
                .function("hand", returnsObject().noParams()) { it.target?.hand }
                .function("rightClicked", returnsObject().noParams()) { it.target?.rightClicked }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerArmorStandManipulateEvent.getHandlerList() }
        }
    }
}
