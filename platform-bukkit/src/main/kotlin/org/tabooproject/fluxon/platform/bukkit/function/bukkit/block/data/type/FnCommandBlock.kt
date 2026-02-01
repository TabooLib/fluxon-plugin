package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.CommandBlock
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

@Requires(classes = ["org.bukkit.block.data.type.CommandBlock"])
@PlatformSide(Platform.BUKKIT)
object FnCommandBlock {

    val TYPE = Type.fromClass(CommandBlock::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandBlock::class.java)
                .function("isConditional", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConditional ?: false) }
                .function("setConditional", returnsVoid().params(Type.Z)) { it.target?.setConditional(it.getBool(0)) }
        }
    }
}
