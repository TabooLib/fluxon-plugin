package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.CommandBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.CommandBlock"])
@PlatformSide(Platform.BUKKIT)
object FnCommandBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandBlock::class.java)
                .function("command", returnsObject().noParams()) { it.target?.command }
                .function("setCommand", returnsObject().params(Type.OBJECT)) { it.target?.setCommand(it.getString(0)) }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("setName", returnsObject().params(Type.OBJECT)) { it.target?.setName(it.getString(0)) }
        }
    }
}
