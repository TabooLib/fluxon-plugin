package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.SculkShrieker
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.SculkShrieker"])
@PlatformSide(Platform.BUKKIT)
object FnSculkShrieker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkShrieker::class.java)
                .function("warningLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.warningLevel) }
                .function("setWarningLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWarningLevel(it.getInt(0).toInt())) }
                .function("tryShriek", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.tryShriek(it.getRef(0) as Player)) }
        }
    }
}
