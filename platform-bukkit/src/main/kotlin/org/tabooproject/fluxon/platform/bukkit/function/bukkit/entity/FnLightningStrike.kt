package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LightningStrike
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.LightningStrike"])
@PlatformSide(Platform.BUKKIT)
object FnLightningStrike {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LightningStrike::class.java)
                .function("isEffect", returns(Type.Z).noParams()) { it.target?.isEffect }
                .function("flashes", returnsObject().noParams()) { it.target?.flashes }
                .function("setFlashes", returnsObject().params(Type.OBJECT)) { it.target?.setFlashes(it.getInt(0).toInt()) }
                .function("lifeTicks", returnsObject().noParams()) { it.target?.lifeTicks }
                .function("setLifeTicks", returnsObject().params(Type.OBJECT)) { it.target?.setLifeTicks(it.getInt(0).toInt()) }
                .function("causingPlayer", returnsObject().noParams()) { it.target?.causingPlayer }
                .function("setCausingPlayer", returnsObject().params(Type.OBJECT)) { it.target?.setCausingPlayer(it.getRef(0) as Player) }
                .function("isSilent", returns(Type.Z).noParams()) { it.target?.isSilent }
        }
    }
}
