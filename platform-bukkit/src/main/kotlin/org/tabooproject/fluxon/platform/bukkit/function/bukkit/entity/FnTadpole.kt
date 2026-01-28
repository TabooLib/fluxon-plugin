package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Tadpole
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Tadpole"])
@PlatformSide(Platform.BUKKIT)
object FnTadpole {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tadpole::class.java)
                .function("age", returnsObject().noParams()) { it.setReturnRef(it.target?.age) }
                .function("setAge", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAge(it.getInt(0).toInt())) }
        }
    }
}
