package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageByBlockEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EntityDamageByBlockEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDamageByBlockEvent {

    val TYPE = Type.fromClass(EntityDamageByBlockEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDamageByBlockEvent::class.java)
                .function("damager",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.damager) }
                .function("damagerBlockState",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.damagerBlockState) }
        }
    }
}
