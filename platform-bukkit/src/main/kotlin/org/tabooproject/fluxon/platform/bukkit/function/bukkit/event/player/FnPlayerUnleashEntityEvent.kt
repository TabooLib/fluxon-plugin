package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerUnleashEntityEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerUnleashEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerUnleashEntityEvent {

    val TYPE = Type.fromClass(PlayerUnleashEntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerUnleashEntityEvent::class.java)
                .function("player",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("hand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.hand) }
        }
    }
}
