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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.PotionSplashEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPotionSplashEvent {

    val TYPE = Type.fromClass(PotionSplashEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionSplashEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("potion",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnThrownPotion.TYPE).noParams()) { it.setReturnRef(it.target?.potion) }
                .function("affectedEntities",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.affectedEntities) }
                .function("getIntensity",returns(Type.D).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE)) { it.setReturnDouble(it.target?.getIntensity(it.getRef(0) as LivingEntity) ?: 0.0) }
                .function("setIntensity",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE, Type.D)) {
                    it.target?.setIntensity(
                        it.getRef(0) as LivingEntity,
                        it.getDouble(1)
                    )
                }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PotionSplashEvent.getHandlerList()) }
        }
    }
}
