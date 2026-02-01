package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Piston
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.Piston"])
@PlatformSide(Platform.BUKKIT)
object FnPiston {

    val TYPE = Type.fromClass(Piston::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Piston::class.java)
                .function("isExtended", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isExtended ?: false) }
                .function("setExtended", returnsVoid().params(Type.Z)) { it.target?.setExtended(it.getBool(0)) }
        }
    }
}
