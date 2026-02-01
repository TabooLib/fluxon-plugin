package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.WanderingTrader
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.WanderingTrader"])
@PlatformSide(Platform.BUKKIT)
object FnWanderingTrader {

    val TYPE = Type.fromClass(WanderingTrader::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WanderingTrader::class.java)
                .function("despawnDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.despawnDelay ?: 0) }
                .function("setDespawnDelay", returnsVoid().params(Type.I)) { it.target?.setDespawnDelay(it.getInt(0).toInt()) }
        }
    }
}
