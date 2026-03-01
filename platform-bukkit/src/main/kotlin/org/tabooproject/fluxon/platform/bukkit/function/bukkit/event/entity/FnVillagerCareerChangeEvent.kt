package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Villager
import org.bukkit.event.entity.VillagerCareerChangeEvent
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

@Requires(classes = ["org.bukkit.event.entity.VillagerCareerChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerCareerChangeEvent {

    val TYPE = Type.fromClass(VillagerCareerChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VillagerCareerChangeEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("setProfession",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillagerProfession.TYPE)) { it.target?.setProfession(it.getRef(0) as Villager.Profession) }
                .function("reason", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnVillagerCareerChangeEventChangeReason.TYPE).noParams()) { it.setReturnRef(it.target?.reason) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(VillagerCareerChangeEvent.getHandlerList()) }
        }
    }
}
