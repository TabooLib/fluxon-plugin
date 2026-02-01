package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Openable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.Openable"])
@PlatformSide(Platform.BUKKIT)
object FnOpenable {

    val TYPE = Type.fromClass(Openable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Openable::class.java)
                .function("isOpen", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOpen ?: false) }
                .function("setOpen", returnsVoid().params(Type.Z)) { it.target?.setOpen(it.getBool(0)) }
        }
    }
}
