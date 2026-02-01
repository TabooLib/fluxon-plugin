package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ChestedHorse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.ChestedHorse"])
@PlatformSide(Platform.BUKKIT)
object FnChestedHorse {

    val TYPE = Type.fromClass(ChestedHorse::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChestedHorse::class.java)
                .function("isCarryingChest", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCarryingChest ?: false) }
                .function("setCarryingChest", returnsVoid().params(Type.Z)) { it.target?.setCarryingChest(it.getBool(0)) }
        }
    }
}
