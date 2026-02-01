package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.StructureBlock
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.StructureBlock"])
@PlatformSide(Platform.BUKKIT)
object FnStructureBlock {

    val TYPE = Type.fromClass(StructureBlock::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureBlock::class.java)
                .function("mode", returns(FnStructureBlockMode.TYPE).noParams()) { it.setReturnRef(it.target?.mode) }
                .function("setMode", returnsVoid().params(FnStructureBlockMode.TYPE)) { it.target?.setMode(it.getRef(0) as StructureBlock.Mode) }
                .function("setMode", returnsVoid().params(Type.STRING)) { FnStructureBlockMode.enumValue(it.getString(0))?.let { p0 -> it.target?.setMode(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.StructureBlock.Mode"])
@PlatformSide(Platform.BUKKIT)
object FnStructureBlockMode : FnEnumGetter<StructureBlock.Mode>()  {

    override val enumClass: Class<StructureBlock.Mode> = StructureBlock.Mode::class.java
}
