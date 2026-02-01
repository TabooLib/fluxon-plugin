package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.SculkShrieker
import org.bukkit.entity.Player
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.SculkShrieker"])
@PlatformSide(Platform.BUKKIT)
object FnSculkShrieker {

    val TYPE = Type.fromClass(SculkShrieker::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkShrieker::class.java)
                .function("warningLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.warningLevel ?: 0) }
                .function("setWarningLevel", returnsVoid().params(Type.I)) { it.target?.setWarningLevel(it.getInt(0)) }
                .function("tryShriek", returnsVoid().params(FnPlayer.TYPE)) { it.target?.tryShriek(it.getRef(0) as Player) }
        }
    }
}
