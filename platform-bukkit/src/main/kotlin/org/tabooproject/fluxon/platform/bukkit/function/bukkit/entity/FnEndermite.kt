package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Endermite
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

@Requires(classes = ["org.bukkit.entity.Endermite"])
@PlatformSide(Platform.BUKKIT)
object FnEndermite {

    val TYPE = Type.fromClass(Endermite::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Endermite::class.java)
                .function("isPlayerSpawned", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlayerSpawned ?: false) }
                .function("setPlayerSpawned", returnsVoid().params(Type.Z)) { it.target?.setPlayerSpawned(it.getBool(0)) }
        }
    }
}
