package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TNT
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.TNT"])
@PlatformSide(Platform.BUKKIT)
object FnTNT {

    val TYPE = Type.fromClass(TNT::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNT::class.java)
                .function("isUnstable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUnstable ?: false) }
                .function("setUnstable", returnsVoid().params(Type.Z)) { it.target?.setUnstable(it.getBool(0)) }
        }
    }
}
