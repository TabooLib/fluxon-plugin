package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Bat
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

@Requires(classes = ["org.bukkit.entity.Bat"])
@PlatformSide(Platform.BUKKIT)
object FnBat {

    val TYPE = Type.fromClass(Bat::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bat::class.java)
                .function("isAwake", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAwake ?: false) }
                .function("setAwake", returnsVoid().params(Type.Z)) { it.target?.setAwake(it.getBool(0)) }
        }
    }
}
