package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityPotionEffectEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EntityPotionEffectEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPotionEffectEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityPotionEffectEvent::class.java)
                .function("oldEffect", returnsObject().noParams()) { it.setReturnRef(it.target?.oldEffect) }
                .function("newEffect", returnsObject().noParams()) { it.setReturnRef(it.target?.newEffect) }
                .function("cause", returnsObject().noParams()) { it.setReturnRef(it.target?.cause) }
                .function("action", returnsObject().noParams()) { it.setReturnRef(it.target?.action) }
                .function("modifiedType", returnsObject().noParams()) { it.setReturnRef(it.target?.modifiedType) }
                .function("isOverride", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isOverride) }
                .function("setOverride", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setOverride(it.getBool(0))) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityPotionEffectEvent.getHandlerList()) }
        }
    }
}
