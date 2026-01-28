package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Snowman
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Snowman"])
@PlatformSide(Platform.BUKKIT)
object FnSnowman {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snowman::class.java)
                .function("isDerp", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isDerp) }
                .function("setDerp", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDerp(it.getBool(0))) }
        }
    }
}
