package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Phantom
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Phantom"])
@PlatformSide(Platform.BUKKIT)
object FnPhantom {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Phantom::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnRef(it.target?.size) }
                .function("setSize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSize(it.getInt(0).toInt())) }
        }
    }
}
