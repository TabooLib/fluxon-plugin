package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LightningStrike
import org.bukkit.entity.Player
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

@Requires(classes = ["org.bukkit.entity.LightningStrike"])
@PlatformSide(Platform.BUKKIT)
object FnLightningStrike {

    val TYPE = Type.fromClass(LightningStrike::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LightningStrike::class.java)
                .function("isEffect", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEffect ?: false) }
                .function("flashes", returns(Type.I).noParams()) { it.setReturnInt(it.target?.flashes ?: 0) }
                .function("setFlashes", returnsVoid().params(Type.I)) { it.target?.setFlashes(it.getInt(0).toInt()) }
                .function("lifeTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lifeTicks ?: 0) }
                .function("setLifeTicks", returnsVoid().params(Type.I)) { it.target?.setLifeTicks(it.getInt(0).toInt()) }
                .function("causingPlayer", returnsObject().noParams()) { it.setReturnRef(it.target?.causingPlayer) }
                .function("setCausingPlayer", returnsVoid().params(Type.OBJECT)) { it.target?.setCausingPlayer(it.getRef(0) as Player) }
                .function("isSilent", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSilent ?: false) }
        }
    }
}
