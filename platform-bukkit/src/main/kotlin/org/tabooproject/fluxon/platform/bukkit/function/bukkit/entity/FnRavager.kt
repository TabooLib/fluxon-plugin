package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Ravager"])
@PlatformSide(Platform.BUKKIT)
object FnRavager {

    val TYPE = Type.fromClass(org.bukkit.entity.Ravager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Ravager::class.java)
                // .function("getAttackTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getAttackTicks() ?: 0) }
                // .function("setAttackTicks", returnsVoid().params(Type.I)) { it.target?.setAttackTicks(it.getInt(0).toInt()) }
                // .function("getStunnedTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getStunnedTicks() ?: 0) }
                // .function("setStunnedTicks", returnsVoid().params(Type.I)) { it.target?.setStunnedTicks(it.getInt(0).toInt()) }
                // .function("getRoarTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getRoarTicks() ?: 0) }
                // .function("setRoarTicks", returnsVoid().params(Type.I)) { it.target?.setRoarTicks(it.getInt(0).toInt()) }
        }
    }
}
