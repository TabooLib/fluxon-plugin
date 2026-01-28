package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.event.entity.PotionSplashEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.PotionSplashEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPotionSplashEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionSplashEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("potion", returnsObject().noParams()) { it.setReturnRef(it.target?.potion) }
                .function("affectedEntities", returnsObject().noParams()) { it.setReturnRef(it.target?.affectedEntities) }
                .function("getIntensity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getIntensity(it.getRef(0) as LivingEntity)) }
                .function("setIntensity", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setIntensity(
                        it.getRef(0) as LivingEntity,
                        it.getAsDouble(1)
                    ))
                }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PotionSplashEvent.getHandlerList()) }
        }
    }
}
