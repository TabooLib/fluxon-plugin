package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.LingeringPotionSplashEvent
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

@Requires(classes = ["org.bukkit.event.entity.LingeringPotionSplashEvent"])
@PlatformSide(Platform.BUKKIT)
object FnLingeringPotionSplashEvent {

    val TYPE = Type.fromClass(LingeringPotionSplashEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LingeringPotionSplashEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
                .function("areaEffectCloud",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAreaEffectCloud.TYPE).noParams()) { it.setReturnRef(it.target?.areaEffectCloud) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(LingeringPotionSplashEvent.getHandlerList()) }
        }
    }
}
