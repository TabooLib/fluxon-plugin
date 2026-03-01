package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Allay
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

@Requires(classes = ["org.bukkit.entity.Allay"])
@PlatformSide(Platform.BUKKIT)
object FnAllay {

    val TYPE = Type.fromClass(Allay::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Allay::class.java)
                .function("canDuplicate", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canDuplicate() ?: false) }
                .function("setCanDuplicate", returnsVoid().params(Type.Z)) { it.target?.setCanDuplicate(it.getBool(0)) }
                .function("duplicationCooldown", returns(Type.J).noParams()) { it.setReturnLong(it.target?.duplicationCooldown ?: 0L) }
                .function("setDuplicationCooldown", returnsVoid().params(Type.J)) { it.target?.setDuplicationCooldown(it.getLong(0)) }
                .function("resetDuplicationCooldown", returnsVoid().noParams()) { it.target?.resetDuplicationCooldown() }
                .function("isDancing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDancing ?: false) }
                .function("startDancing", returnsVoid().noParams()) { it.target?.startDancing() }
                .function("startDancing",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.startDancing(it.getRef(0) as Location) }
                .function("stopDancing", returnsVoid().noParams()) { it.target?.stopDancing() }
                .function("duplicateAllay",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAllay.TYPE).noParams()) { it.setReturnRef(it.target?.duplicateAllay()) }
                .function("jukebox",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.jukebox) }
        }
    }
}
