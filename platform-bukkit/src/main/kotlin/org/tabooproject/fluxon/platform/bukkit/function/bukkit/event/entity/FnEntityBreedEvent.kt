package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityBreedEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EntityBreedEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityBreedEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityBreedEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("mother", returnsObject().noParams()) { it.setReturnRef(it.target?.mother) }
                .function("father", returnsObject().noParams()) { it.setReturnRef(it.target?.father) }
                .function("breeder", returnsObject().noParams()) { it.setReturnRef(it.target?.breeder) }
                .function("bredWith", returnsObject().noParams()) { it.setReturnRef(it.target?.bredWith) }
                .function("experience", returnsObject().noParams()) { it.setReturnRef(it.target?.experience) }
                .function("setExperience", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExperience(it.getInt(0).toInt())) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityBreedEvent.getHandlerList()) }
        }
    }
}
