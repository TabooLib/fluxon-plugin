package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TNT
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.TNT"])
@PlatformSide(Platform.BUKKIT)
object FnTNT {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNT::class.java)
                .function("isUnstable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isUnstable) }
                .function("setUnstable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUnstable(it.getBool(0))) }
        }
    }
}
