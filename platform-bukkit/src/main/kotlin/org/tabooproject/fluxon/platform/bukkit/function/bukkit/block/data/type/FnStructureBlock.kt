package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.StructureBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.StructureBlock"])
@PlatformSide(Platform.BUKKIT)
object FnStructureBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureBlock::class.java)
                .function("mode", returnsObject().noParams()) { it.target?.mode }
                .function("setMode", returnsObject().params(Type.OBJECT)) { it.target?.setMode(it.getRef(0) as StructureBlock.Mode) }
        }
    }
}
