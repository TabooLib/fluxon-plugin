package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BrushableBlock
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.BrushableBlock"])
@PlatformSide(Platform.BUKKIT)
object FnBrushableBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrushableBlock::class.java)
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItem(it.getRef(0) as ItemStack)) }
        }
    }
}
