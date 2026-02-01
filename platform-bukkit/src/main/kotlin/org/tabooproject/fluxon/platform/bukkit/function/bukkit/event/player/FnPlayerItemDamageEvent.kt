package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerItemDamageEvent
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


@Requires(classes = ["org.bukkit.event.player.PlayerItemDamageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerItemDamageEvent {

    val TYPE = Type.fromClass(PlayerItemDamageEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerItemDamageEvent::class.java)
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("damage", returnsObject().noParams()) { it.setReturnRef(it.target?.damage) }
                .function("setDamage", returnsVoid().params(Type.I)) { it.target?.setDamage(it.getInt(0).toInt()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerItemDamageEvent.getHandlerList()) }
        }
    }
}
