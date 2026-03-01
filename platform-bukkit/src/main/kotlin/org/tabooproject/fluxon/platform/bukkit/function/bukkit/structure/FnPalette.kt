package org.tabooproject.fluxon.platform.bukkit.function.bukkit.structure

import org.bukkit.structure.Palette
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.structure.Palette"])
@PlatformSide(Platform.BUKKIT)
object FnPalette {

    val TYPE = Type.fromClass(Palette::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Palette::class.java)
                .function("blocks",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("blockCount",returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockCount) }
        }
    }
}
