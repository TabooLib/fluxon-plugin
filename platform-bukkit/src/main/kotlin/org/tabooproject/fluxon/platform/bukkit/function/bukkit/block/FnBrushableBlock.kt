package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BrushableBlock
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.BrushableBlock"])
@PlatformSide(Platform.BUKKIT)
object FnBrushableBlock {

    val TYPE = Type.fromClass(BrushableBlock::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrushableBlock::class.java)
                .function("item", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setItem(it.getRef(0) as ItemStack) }
        }
    }
}
