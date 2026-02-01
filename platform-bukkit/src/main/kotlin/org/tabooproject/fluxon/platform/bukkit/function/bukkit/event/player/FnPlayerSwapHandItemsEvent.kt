package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.inventory.ItemStack
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

@Requires(classes = ["org.bukkit.event.player.PlayerSwapHandItemsEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerSwapHandItemsEvent {

    val TYPE = Type.fromClass(PlayerSwapHandItemsEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerSwapHandItemsEvent::class.java)
                .function("mainHandItem", returnsObject().noParams()) { it.setReturnRef(it.target?.mainHandItem) }
                .function("setMainHandItem", returnsVoid().params(Type.OBJECT)) { it.target?.setMainHandItem(it.getRef(0) as ItemStack) }
                .function("offHandItem", returnsObject().noParams()) { it.setReturnRef(it.target?.offHandItem) }
                .function("setOffHandItem", returnsVoid().params(Type.OBJECT)) { it.target?.setOffHandItem(it.getRef(0) as ItemStack) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerSwapHandItemsEvent.getHandlerList()) }
        }
    }
}
