package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Snowman
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

@Requires(classes = ["org.bukkit.entity.Snowman"])
@PlatformSide(Platform.BUKKIT)
object FnSnowman {

    val TYPE = Type.fromClass(Snowman::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snowman::class.java)
                .function("isDerp", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDerp ?: false) }
                .function("setDerp", returnsVoid().params(Type.Z)) { it.target?.setDerp(it.getBool(0)) }
        }
    }
}
